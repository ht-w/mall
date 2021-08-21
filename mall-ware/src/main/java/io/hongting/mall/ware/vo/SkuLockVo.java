package io.hongting.mall.ware.vo;

import lombok.Data;

import java.util.List;

/**
 * @author hongting
 * @create 2021 08 12 7:23 PM
 */
@Data
public class SkuLockVo{
    private Long skuId;
    private Integer num;
    private List<Long> wareIds;
}
