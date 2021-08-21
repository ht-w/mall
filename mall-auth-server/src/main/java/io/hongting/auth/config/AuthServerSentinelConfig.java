package io.hongting.auth.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.WebCallbackManager;
import com.alibaba.fastjson.JSON;
import io.hongting.common.exception.BizCodeEnum;
import io.hongting.common.utils.R;
import org.springframework.context.annotation.Configuration;

/**
 * @author hongting
 * @create 2021 08 19 3:31 PM
 */
@Configuration
public class AuthServerSentinelConfig {

    public AuthServerSentinelConfig(){
        WebCallbackManager.setUrlBlockHandler((request, response, exception) -> {
            R error = R.error(BizCodeEnum.READ_TIME_OUT_EXCEPTION.getCode(), BizCodeEnum.READ_TIME_OUT_EXCEPTION.getMessage());
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.getWriter().write(JSON.toJSONString(error));
        });
    }
}