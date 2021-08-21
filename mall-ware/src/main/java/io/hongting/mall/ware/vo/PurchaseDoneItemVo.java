package io.hongting.mall.ware.vo;

import lombok.Data;

/**
 * @author hongting
 * @create 2021 06 24 6:49 PM
 */


@Data
public class PurchaseDoneItemVo {

    private Long itemId;
    private Integer status;
    private String reason;

}
