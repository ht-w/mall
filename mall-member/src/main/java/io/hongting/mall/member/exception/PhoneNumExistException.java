package io.hongting.mall.member.exception;

/**
 * @author hongting
 * @create 2021 07 21 8:01 PM
 */
public class PhoneNumExistException extends RuntimeException {
    public PhoneNumExistException() {
        super("phone number existed");
    }
}
