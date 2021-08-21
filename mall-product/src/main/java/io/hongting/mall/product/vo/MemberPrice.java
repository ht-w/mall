package io.hongting.mall.product.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author hongting
 * @create 2021 06 23 7:13 PM
 */
@Data
public class MemberPrice {

    private Long id;
    private String name;
    private BigDecimal price;

}