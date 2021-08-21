package io.hongting.mall.ware.feign;

import io.hongting.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hongting
 * @create 2021 08 12 8:40 PM
 */
@FeignClient("mall-order")
public interface OrderFeignService {

    @RequestMapping("order/order/infoByOrderSn/{OrderSn}")
    R infoByOrderSn(@PathVariable("OrderSn") String OrderSn);
}

