package io.hongting.mall.order.vo;

import io.hongting.mall.order.entity.OrderEntity;
import lombok.Data;

/**
 * @author hongting
 * @create 2021 08 11 10:02 PM
 */
@Data
public class SubmitOrderResponseVo {

    private OrderEntity order;

    /** 错误状态码 **/
    private Integer code;
}
