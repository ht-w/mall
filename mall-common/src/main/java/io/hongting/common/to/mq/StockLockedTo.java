package io.hongting.common.to.mq;

import lombok.Data;

/**
 * @author hongting
 * @create 2021 08 12 8:22 PM
 */

@Data
public class StockLockedTo {

    private Long id;

    private StockDetailTo detailTo;
}
