package io.hongting.common.to;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author hongting
 * @create 2021 06 24 2:08 PM
 */
@Data
public class MemberPrice {

    private Long id;
    private String name;
    private BigDecimal price;

}
