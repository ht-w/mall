package io.hongting.common.exception;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author hongting
 * @create 2021 08 12 12:48 PM
 */

public class NoStockException extends RuntimeException{

    @Setter
    @Getter
    private Long skuId;

    public NoStockException(Long skuId) {
        super("商品id:"+skuId+";库存不足");
    }

    public NoStockException(String message) {
        super(message);
    }
}


