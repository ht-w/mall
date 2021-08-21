package io.hongting.mall.ware.vo;

import lombok.Data;

import java.util.List;

/**
 * @author hongting
 * @create 2021 06 24 4:49 PM
 */

@Data
public class MergeVo {

    private Long purchaseId;
    private List<Long> items;
}
