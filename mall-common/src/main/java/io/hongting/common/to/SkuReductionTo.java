package io.hongting.common.to;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author hongting
 * @create 2021 06 24 2:04 PM
 */
@Data
public class SkuReductionTo {

    private Long skuId;
    private int fullCount;
    private BigDecimal discount;
    private int countStatus;
    private BigDecimal fullPrice;
    private BigDecimal reducePrice;
    private int priceStatus;
    private List<MemberPrice> memberPrice;
}