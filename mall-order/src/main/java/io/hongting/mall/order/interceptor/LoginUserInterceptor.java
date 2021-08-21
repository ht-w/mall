package io.hongting.mall.order.interceptor;

import io.hongting.common.constant.AuthServerConstant;
import io.hongting.common.vo.MemberResponseVo;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author hongting
 * @create 2021 08 11 1:10 PM
 */

@Component
public class LoginUserInterceptor implements HandlerInterceptor {

    public static ThreadLocal<MemberResponseVo>  threadLocal= new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        String requestURI = request.getRequestURI();
        AntPathMatcher matcher = new AntPathMatcher();
        boolean match1 = matcher.match("/order/order/infoByOrderSn/**", requestURI);
        boolean match2 = matcher.match("/payed/**", requestURI);
        if (match1||match2) return true;

        HttpSession session = request.getSession();
        MemberResponseVo attribute = (MemberResponseVo) session.getAttribute(AuthServerConstant.LOGIN_USER);
        if(attribute!=null){
            threadLocal.set(attribute);
            return true;
        }else{
            request.getSession().setAttribute("msg", "请先进行登入");
            response.sendRedirect("http://auth.mall.com/login.html");
            return false;
        }
    }
}
