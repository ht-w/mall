package io.hongting.mall.ware.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author hongting
 * @create 2021 08 11 8:49 PM
 */
@Data
public class FareVo {
    private MemberAddressVo address;
    private BigDecimal fare;
}

