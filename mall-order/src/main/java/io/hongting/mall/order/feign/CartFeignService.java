package io.hongting.mall.order.feign;

import io.hongting.mall.order.vo.OrderItemVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author hongting
 * @create 2021 08 11 2:09 PM
 */


@FeignClient("mall-cart")
public interface CartFeignService {

    @ResponseBody
    @RequestMapping("/getCheckedItems")
    List<OrderItemVo> getCheckedItems();
}

