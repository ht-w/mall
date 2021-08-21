package io.hongting.mall.order.vo;

import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author hongting
 * @create 2021 08 11 1:35 PM
 */
@Data
public class OrderItemVo {
    private Long skuId;

    private Boolean check = true;

    private String title;

    private String image;

    /**
     * 商品套餐属性
     */
    private List<String> skuAttrValues;

    private BigDecimal price;

    private Integer count;

    private BigDecimal totalPrice;

    /** 商品重量 **/
    private BigDecimal weight = new BigDecimal("0.085");
}

