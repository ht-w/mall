package io.hongting.cart.feign;

import io.hongting.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author hongting
 * @create 2021 08 09 5:57 PM
 */
@FeignClient("mall-product")
public interface ProductFeignService {
    @RequestMapping("product/skuinfo/info/{skuId}")
    R info(@PathVariable("skuId") Long skuId);

    @RequestMapping("product/skusaleattrvalue/getSkuSaleAttrValuesAsString")
    List<String> getSkuSaleAttrValuesAsString(@RequestBody Long skuId);
}

