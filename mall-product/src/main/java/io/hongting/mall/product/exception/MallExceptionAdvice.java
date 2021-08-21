package io.hongting.mall.product.exception;

import com.sun.media.jfxmedia.logging.Logger;
import io.hongting.common.exception.BizCodeEnum;
import io.hongting.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Var;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

/**
 * @author hongting
 * @create 2021 06 21 10:34 PM
 */

@Slf4j
@RestControllerAdvice(basePackages = "io.hongting.mall.product.controller")
public class MallExceptionAdvice {

    @ExceptionHandler(Exception.class)
    public R handleValidException(MethodArgumentNotValidException e){
        HashMap<String,String> map = new HashMap<>();
        BindingResult result = e.getBindingResult();
        result.getFieldErrors().forEach((item)->{
            String field = item.getField();
            String defaultMessage = item.getDefaultMessage();
            map.put(field, defaultMessage);
        });
        log.error("data validation issue{},exception type{}",e.getMessage(),e.getClass());
        return R.error(BizCodeEnum.VALID_EXCEPTION.getCode(), BizCodeEnum.VALID_EXCEPTION.getMessage())
                .put("data", map);
    }

    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable throwable){
        log.error("unknown exception{},exception type{}",throwable.getMessage(),throwable.getClass());
        return R.error(BizCodeEnum.UNKNOWN_EXCEPTION.getCode(),BizCodeEnum.UNKNOWN_EXCEPTION.getMessage());
    }
}

