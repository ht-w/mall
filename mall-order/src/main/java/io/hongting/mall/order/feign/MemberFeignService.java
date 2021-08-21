package io.hongting.mall.order.feign;

import io.hongting.mall.order.vo.MemberAddressVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author hongting
 * @create 2021 08 11 1:43 PM
 */

@FeignClient("mall-member")
public interface MemberFeignService {

    @GetMapping("member/memberreceiveaddress/{memberId}/addresses")
    List<MemberAddressVo> getAddress(@PathVariable("memberId") Long memberId);

}

