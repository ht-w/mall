package io.hongting.mall.ware.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


import io.hongting.common.exception.BizCodeEnum;
import io.hongting.common.exception.NoStockException;
import io.hongting.mall.ware.vo.SkuHasStockVo;
import io.hongting.mall.ware.vo.WareSkuLockVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.hongting.mall.ware.entity.WareSkuEntity;
import io.hongting.mall.ware.service.WareSkuService;
import io.hongting.common.utils.PageUtils;
import io.hongting.common.utils.R;



/**
 * 商品库存
 *
 * @author hongting
 * @email hongting@gmail.com
 * @date 2021-06-18 21:11:17
 */
@RestController
@RequestMapping("ware/waresku")
public class WareSkuController {
    @Autowired
    private WareSkuService wareSkuService;



    /**
     * 下订单时锁库存
     * @param
     * @return
     */
    @RequestMapping("/lock/order")
    public R orderLockStock(@RequestBody WareSkuLockVo lockVo) {
        try {
            Boolean lock = wareSkuService.orderLockStock(lockVo);
            return R.ok();
        } catch (NoStockException e) {
            return R.error(BizCodeEnum.NO_STOCK_EXCEPTION.getCode(), BizCodeEnum.NO_STOCK_EXCEPTION.getMessage());
        }
    }


    /**
     * 列表
     */
    @RequestMapping("/list")
   // @RequiresPermissions("ware:waresku:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = wareSkuService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * check whether sku has stock
     */
    @PostMapping("/hasstock")
    public R getSkuHasStock(@RequestBody List<Long> skuIds){
        List<SkuHasStockVo> skuHasStockVos = wareSkuService.getSkuHasStock(skuIds);
        return R.ok().setData(skuHasStockVos);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
   // @RequiresPermissions("ware:waresku:info")
    public R info(@PathVariable("id") Long id){
		WareSkuEntity wareSku = wareSkuService.getById(id);

        return R.ok().put("wareSku", wareSku);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
   // @RequiresPermissions("ware:waresku:save")
    public R save(@RequestBody WareSkuEntity wareSku){
		wareSkuService.save(wareSku);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("ware:waresku:update")
    public R update(@RequestBody WareSkuEntity wareSku){
		wareSkuService.updateById(wareSku);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
   // @RequiresPermissions("ware:waresku:delete")
    public R delete(@RequestBody Long[] ids){
		wareSkuService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
