package io.hongting.common.to;

import lombok.Data;

/**
 * @author hongting
 * @create 2021 06 28 6:49 PM
 */

@Data
public class SkuHasStockVo {

    private Long skuId;

    private Boolean hasStock;
}
