package io.honting.mall.seckill.feign;

import io.hongting.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hongting
 * @create 2021 08 18 11:31 AM
 */
@FeignClient(value = "mall-coupon")
public interface CouponFeignService {
    @RequestMapping("coupon/seckillsession/getSeckillSessionsIn3Days")
    R getSeckillSessionsIn3Days();
}
