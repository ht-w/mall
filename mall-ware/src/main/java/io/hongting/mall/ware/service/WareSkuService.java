package io.hongting.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.hongting.common.to.mq.OrderTo;
import io.hongting.common.to.mq.StockLockedTo;
import io.hongting.common.utils.PageUtils;
import io.hongting.mall.ware.entity.WareSkuEntity;
import io.hongting.mall.ware.vo.SkuHasStockVo;
import io.hongting.mall.ware.vo.WareSkuLockVo;

import java.util.List;
import java.util.Map;

/**
 * 商品库存
 *
 * @author hongting
 * @email hongting@gmail.com
 * @date 2021-06-18 21:11:17
 */
public interface WareSkuService extends IService<WareSkuEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void addStock(Long skuId, Long wareId, Integer skuNum);

    List<SkuHasStockVo> getSkuHasStock(List<Long> skuIds);

    Boolean orderLockStock(WareSkuLockVo lockVo);

    void unlock(StockLockedTo stockLockedTo);

    void unlock(OrderTo orderTo);
}

