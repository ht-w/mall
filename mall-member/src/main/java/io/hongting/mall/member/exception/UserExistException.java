package io.hongting.mall.member.exception;

/**
 * @author hongting
 * @create 2021 07 21 8:03 PM
 */
public class UserExistException extends RuntimeException {
    public UserExistException() {
        super("username existed");
    }
}