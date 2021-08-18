package io.hongting.cart.to;

import lombok.Data;

/**
 * @author hongting
 * @create 2021 08 09 4:25 PM
 */
@Data
public class UserInfoTo {

    private Long userId;

    private String userKey;

    /**
     * 浏览器是否已有user-key
     */
    private Boolean tempUser = false;

}
