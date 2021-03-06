package io.hongting.mall.ware.service.impl;

import com.alibaba.fastjson.TypeReference;
import io.hongting.common.exception.NoStockException;
import io.hongting.common.to.mq.OrderTo;
import io.hongting.common.to.mq.StockDetailTo;
import io.hongting.common.to.mq.StockLockedTo;
import io.hongting.common.utils.R;
import io.hongting.mall.ware.entity.WareOrderTaskDetailEntity;
import io.hongting.mall.ware.entity.WareOrderTaskEntity;
import io.hongting.mall.ware.enums.OrderStatusEnum;
import io.hongting.mall.ware.enums.WareTaskStatusEnum;
import io.hongting.mall.ware.feign.OrderFeignService;
import io.hongting.mall.ware.feign.ProductFeignService;
import io.hongting.mall.ware.service.WareOrderTaskDetailService;
import io.hongting.mall.ware.service.WareOrderTaskService;
import io.hongting.mall.ware.vo.OrderItemVo;
import io.hongting.mall.ware.vo.SkuHasStockVo;
import io.hongting.mall.ware.vo.SkuLockVo;
import io.hongting.mall.ware.vo.WareSkuLockVo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.hongting.common.utils.PageUtils;
import io.hongting.common.utils.Query;

import io.hongting.mall.ware.dao.WareSkuDao;
import io.hongting.mall.ware.entity.WareSkuEntity;
import io.hongting.mall.ware.service.WareSkuService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


@Service("wareSkuService")
public class WareSkuServiceImpl extends ServiceImpl<WareSkuDao, WareSkuEntity> implements WareSkuService {


    @Autowired
    private WareSkuDao wareSkuDao;

    @Autowired
    private ProductFeignService productFeignService;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    WareOrderTaskService wareOrderTaskService;

    @Autowired
    WareOrderTaskDetailService wareOrderTaskDetailService;


    @Autowired
    OrderFeignService orderFeignService;



    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper<WareSkuEntity> queryWrapper = new QueryWrapper<>();
        String skuId = (String)params.get("skuId");
        if(!StringUtils.isEmpty(skuId)){
            queryWrapper.eq("skuId", skuId);
        }
        String wareId = (String)params.get("wareId");
        if(!StringUtils.isEmpty(skuId)){
            queryWrapper.eq("wareId", wareId);
        }
        IPage<WareSkuEntity> page = this.page(
                new Query<WareSkuEntity>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }

    @Transactional
    @Override
    public void addStock(Long skuId, Long wareId, Integer skuNum) {

        QueryWrapper<WareSkuEntity> wrapper = new QueryWrapper<WareSkuEntity>().eq("sku_id", skuId).eq("ware_id", wareId);
        List<WareSkuEntity> wareSkuEntities = wareSkuDao.selectList(wrapper);
        if (wareSkuEntities == null|| wareSkuEntities.size()==0){
            WareSkuEntity skuEntity = new WareSkuEntity();
            skuEntity.setSkuId(skuId);
            skuEntity.setStock(skuNum);
            skuEntity.setWareId(wareId);
            skuEntity.setStockLocked(0);
            //doesnt have to rollback , catch exception
            try {
                R info = productFeignService.info(skuId);
                Map<String,Object> data = (Map<String,Object>)info.get("skuInfo");
                if (info.getCode() == 0) {
                    skuEntity.setSkuName((String)data.get("skuName"));
                }
            }catch (Exception e){

            }
            wareSkuDao.insert(skuEntity);
        }else{
            wareSkuDao.addStock(skuId, wareId, skuNum);
        }
    }

    @Override
    public List<SkuHasStockVo> getSkuHasStock(List<Long> skuIds) {
      return    skuIds.stream().map(skuId->{
            SkuHasStockVo skuHasStockVo = new SkuHasStockVo();
            long count = baseMapper.getSkuStock(skuId);
            skuHasStockVo.setSkuId(skuId);
            skuHasStockVo.setHasStock(count>0);
            return  skuHasStockVo;
        }).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public Boolean orderLockStock(WareSkuLockVo wareSkuLockVo) {
        //??????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
        WareOrderTaskEntity taskEntity = new WareOrderTaskEntity();
        taskEntity.setOrderSn(wareSkuLockVo.getOrderSn());
        taskEntity.setCreateTime(new Date());
        wareOrderTaskService.save(taskEntity);

        List<OrderItemVo> itemVos = wareSkuLockVo.getLocks();
        List<SkuLockVo> lockVos = itemVos.stream().map((item) -> {
            SkuLockVo skuLockVo = new SkuLockVo();
            skuLockVo.setSkuId(item.getSkuId());
            skuLockVo.setNum(item.getCount());
            //??????????????????????????????????????????
            List<Long> wareIds = baseMapper.listWareIdsHasStock(item.getSkuId(), item.getCount());
            skuLockVo.setWareIds(wareIds);
            return skuLockVo;
        }).collect(Collectors.toList());

        for (SkuLockVo lockVo : lockVos) {
            boolean lock = true;
            Long skuId = lockVo.getSkuId();
            List<Long> wareIds = lockVo.getWareIds();
            //????????????????????????????????????????????????
            if (wareIds == null || wareIds.size() == 0) {
                throw new NoStockException(skuId);
            }else {
                for (Long wareId : wareIds) {
                    Long count=baseMapper.lockWareSku(skuId, lockVo.getNum(), wareId);
                    if (count==0){
                        lock=false;
                    }else {
                        //????????????????????????????????????
                        WareOrderTaskDetailEntity detailEntity = WareOrderTaskDetailEntity.builder()
                                .skuId(skuId)
                                .skuName("")
                                .skuNum(lockVo.getNum())
                                .taskId(taskEntity.getId())
                                .wareId(wareId)
                                .lockStatus(1).build();
                        wareOrderTaskDetailService.save(detailEntity);
                        //???????????????????????????????????????
                        StockLockedTo lockedTo = new StockLockedTo();
                        lockedTo.setId(taskEntity.getId());
                        StockDetailTo detailTo = new StockDetailTo();
                        BeanUtils.copyProperties(detailEntity,detailTo);
                        lockedTo.setDetailTo(detailTo);
                        rabbitTemplate.convertAndSend("stock-event-exchange","stock.locked",lockedTo);

                        lock = true;
                        break;
                    }
                }
            }
            if (!lock) throw new NoStockException(skuId);
        }
        return true;
    }

    /**
     *    1??????????????????????????????????????????
     *          *          2??????????????????????????????????????????
     *          *              ???????????????????????????????????????
     *          *                      ??????????????????????????????
     * ????????????????????????
     * @param stockLockedTo
     */

    @Override
    public void unlock(StockLockedTo stockLockedTo) {
        StockDetailTo detailTo = stockLockedTo.getDetailTo();
        WareOrderTaskDetailEntity detailEntity = wareOrderTaskDetailService.getById(detailTo.getId());
        //1.????????????????????????????????????????????????????????????
        if (detailEntity != null) {
            WareOrderTaskEntity taskEntity = wareOrderTaskService.getById(stockLockedTo.getId());
            R r = orderFeignService.infoByOrderSn(taskEntity.getOrderSn());
            if (r.getCode() == 0) {
                OrderTo order = r.getData("order", new TypeReference<OrderTo>() {
                });
                //??????????????????||???????????????????????? ????????????
                if (order == null|| order.getStatus().equals(OrderStatusEnum.CANCLED.getCode())) {
                    //???????????????????????????????????????????????????????????????????????????????????????
                    if (detailEntity.getLockStatus().equals(WareTaskStatusEnum.Locked.getCode())){
                        unlockStock(detailTo.getSkuId(), detailTo.getSkuNum(), detailTo.getWareId(), detailEntity.getId());
                    }
                }
            }else {
                throw new RuntimeException("??????????????????????????????");
            }
        }else {
            //????????????
        }
    }
    @Override
    public void unlock(OrderTo orderTo) {
        //???????????????????????????????????????????????????
        String orderSn = orderTo.getOrderSn();
        WareOrderTaskEntity taskEntity = wareOrderTaskService.getBaseMapper().selectOne((new QueryWrapper<WareOrderTaskEntity>().eq("order_sn", orderSn)));
        //?????????????????????????????????????????????????????????????????????
        List<WareOrderTaskDetailEntity> lockDetails = wareOrderTaskDetailService.list(new QueryWrapper<WareOrderTaskDetailEntity>().eq("task_id", taskEntity.getId()).eq("lock_status", WareTaskStatusEnum.Locked.getCode()));
        for (WareOrderTaskDetailEntity lockDetail : lockDetails) {
            unlockStock(lockDetail.getSkuId(),lockDetail.getSkuNum(),lockDetail.getWareId(),lockDetail.getId());
        }
    }

    private void unlockStock(Long skuId, Integer skuNum, Long wareId, Long detailId) {
        //??????????????????????????????
        baseMapper.unlockStock(skuId, skuNum, wareId);
        //????????????????????????????????????
        WareOrderTaskDetailEntity detail = WareOrderTaskDetailEntity.builder()
                .id(detailId)
                .lockStatus(2).build();
        wareOrderTaskDetailService.updateById(detail);
    }

}