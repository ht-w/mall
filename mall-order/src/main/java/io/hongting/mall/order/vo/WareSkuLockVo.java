package io.hongting.mall.order.vo;

import lombok.Data;

import java.util.List;

/**
 * @author hongting
 * @create 2021 08 12 12:22 PM
 */
@Data
public class WareSkuLockVo {
    private String OrderSn;

    private List<OrderItemVo> locks;
}
