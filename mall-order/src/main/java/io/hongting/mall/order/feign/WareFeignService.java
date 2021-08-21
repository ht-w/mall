package io.hongting.mall.order.feign;

import io.hongting.common.utils.R;
import io.hongting.mall.order.vo.FareVo;
import io.hongting.mall.order.vo.WareSkuLockVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author hongting
 * @create 2021 08 11 7:12 PM
 */


@FeignClient("mall-ware")
public interface WareFeignService {

    @PostMapping("ware/waresku/hasstock")
    R getSkuHasStock(@RequestBody List<Long> skuIds);


    @RequestMapping("ware/wareinfo/fare/{addrId}")
    FareVo getFare(@PathVariable("addrId") Long addrId);


    @RequestMapping("ware/waresku/lock/order")
    R orderLockStock(@RequestBody WareSkuLockVo itemVos);
}

