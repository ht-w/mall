package io.hongting.auth.feign;

import io.hongting.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author hongting
 * @create 2021 07 20 9:32 PM
 */

@FeignClient("mall-third-party")
public interface ThirdPartyFeignService {

    @GetMapping("/sms/sendcode")
    public R sendCode(@RequestParam("phone") String phone, @RequestParam("code") String code);
}
