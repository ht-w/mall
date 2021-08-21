package io.honting.mall.seckill.interceptor;

/**
 * @author hongting
 * @create 2021 08 18 1:34 PM
 */

import io.hongting.common.constant.AuthServerConstant;
import io.hongting.common.vo.MemberResponseVo;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器，未登录的用户不能进入订单服务
 */


@Component
public class LoginInterceptor implements HandlerInterceptor {

    public static ThreadLocal<MemberResponseVo> loginUser = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String uri = request.getRequestURI();
        // 这个请求直接放行
        boolean match = new AntPathMatcher().match("/kill", uri);
        if(match){
            HttpSession session = request.getSession();
            MemberResponseVo memberRsepVo = (MemberResponseVo) session.getAttribute(AuthServerConstant.LOGIN_USER);
            if(memberRsepVo != null){
                loginUser.set(memberRsepVo);
                return true;
            }else{
                // 没登陆就去登录
                session.setAttribute("msg", AuthServerConstant.NOT_LOGIN);
                response.sendRedirect("http://auth.glmall.com/login.html");
                return false;
            }
        }
        return true;
    }
}
