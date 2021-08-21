package io.hongting.mall.order.web;

import io.hongting.common.exception.NoStockException;
import io.hongting.common.vo.MemberResponseVo;
import io.hongting.mall.order.feign.CartFeignService;
import io.hongting.mall.order.feign.MemberFeignService;
import io.hongting.mall.order.interceptor.LoginUserInterceptor;
import io.hongting.mall.order.service.OrderService;
import io.hongting.mall.order.vo.*;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author hongting
 * @create 2021 08 11 1:30 PM
 */

@Controller
public class OrderWebController {

    @Autowired
    OrderService orderService;



    @GetMapping("/toTrade")
    public String toTrade(Model model, HttpServletRequest request) throws ExecutionException, InterruptedException {
        OrderConfirmVo orderConfirmVo =  orderService.confirmOrder();
        model.addAttribute("confirmOrder", orderConfirmVo);
        return "confirm";
    }

    @RequestMapping("/submitOrder")
    public String submitOrder(OrderSubmitVo submitVo, Model model, RedirectAttributes attributes) {
        try{
            SubmitOrderResponseVo responseVo=orderService.submitOrder(submitVo);
            Integer code = responseVo.getCode();
            if (code==0){
                model.addAttribute("order", responseVo.getOrder());
                return "pay";
            }else {
                String msg = "下单失败;";
                switch (code) {
                    case 1:
                        msg += "防重令牌校验失败";
                        break;
                    case 2:
                        msg += "商品价格发生变化";
                        break;
                }
                attributes.addFlashAttribute("msg", msg);
                return "redirect:http://order.gulimall.com/toTrade";
            }
        }catch (Exception e){
            if (e instanceof NoStockException){
                String msg = "下单失败，商品无库存";
                attributes.addFlashAttribute("msg", msg);
            }
            return "redirect:http://order.gulimall.com/toTrade";
        }
    }


}
