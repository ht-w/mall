package io.hongting.mall.thirdparty.controller;

import io.hongting.common.utils.R;
import io.hongting.mall.thirdparty.component.SmsComponent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * @author hongting
 * @create 2021 08 17 2:22 PM
 */
@Controller
@RequestMapping(value = "/sms")
public class SmsSendController {

//    @Resource
//    private SmsComponent smsComponent;

    /**
     * 提供给别的服务进行调用
     * @param phone
     * @param code
     * @return
//     */
//    @GetMapping(value = "/sendCode")
//    public R sendCode(@RequestParam("phone") String phone, @RequestParam("code") String code) {
//        //发送验证码
//        smsComponent.sendCode(phone,code);
//        return R.ok();
//    }
}