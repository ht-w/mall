package io.hongting.mall.order.to;

import io.hongting.mall.order.entity.OrderEntity;
import io.hongting.mall.order.entity.OrderItemEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author hongting
 * @create 2021 08 12 12:19 PM
 */
@Data
public class OrderCreateTo {

    private OrderEntity order;

    private List<OrderItemEntity> orderItems;

    /** 订单计算的应付价格 **/
    private BigDecimal payPrice;

    /** 运费 **/
    private BigDecimal fare;

}