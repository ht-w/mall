package io.hongting.common.to;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author hongting
 * @create 2021 06 24 1:47 PM
 */

@Data
public class SpuBoundTo {

    private Long spuId;

    private BigDecimal buyBounds;

    private BigDecimal growBounds;

}
