package io.hongting.auth.feign;


import io.hongting.auth.vo.SocialUser;
import io.hongting.auth.vo.UserLoginVo;
import io.hongting.auth.vo.UserRegisterVo;
import io.hongting.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author hongting
 * @create 2021 07 28 5:07 PM
 */

@FeignClient(value ="mall-member")
public interface MemberFeignService {


    @RequestMapping("member/member/register")
    R register(@RequestBody UserRegisterVo registerVo);


    @RequestMapping("member/member/login")
    R login(@RequestBody UserLoginVo loginVo);

    @RequestMapping("member/member/oauth2/login")
    R login(@RequestBody SocialUser socialUser);

}
