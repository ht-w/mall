package io.hongting.mall.order.feign;

import io.hongting.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hongting
 * @create 2021 08 12 12:40 PM
 */

@FeignClient("mall-product")
public interface ProductFeignService {

    @RequestMapping("/product/skuinfo/info/{skuId}")
    R info(@PathVariable("skuId") Long skuId);

    @RequestMapping("/product/spuinfo/skuId/{skuId}")
    R getSpuBySkuId(@PathVariable("skuId") Long skuId);
}

