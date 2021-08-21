package io.hongting.common.exception;

import io.hongting.common.constant.ProductConstant;
import org.omg.CORBA.UNKNOWN;

/**
 * @author hongting
 * @create 2021 06 21 10:29 PM
 */

public enum BizCodeEnum {

    VALID_EXCEPTION(10001,"Parameter validation failure"),
    SMS_CODE_EXCEPTION(10002,"request validation  code too frequent, please try later"),
    UNKNOWN_EXCEPTION(10000,"System unknowm exception"),
    PRODUCT_UP_EXCEPTION(11000,"Goods put on sale exception"),
    USER_EXIST_EXCEPTION(15001, "username existed"),
    PHONE_EXIST_EXCEPTION(15002, "phone existed"),
    NO_STOCK_EXCEPTION(21000, "stock is not available"),
    LOGIN_ACCOUNT_PASSWORD_EXCEPTION(15003, "username and password exception"),
    READ_TIME_OUT_EXCEPTION(10004,"远程调用服务超时，请重新再试"),
    TO0_MANY_REQUEST (10002,"too many requests") ;
    private String message;
    private Integer code;

    BizCodeEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
