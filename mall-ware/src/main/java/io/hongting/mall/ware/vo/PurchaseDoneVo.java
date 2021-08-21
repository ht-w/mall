package io.hongting.mall.ware.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author hongting
 * @create 2021 06 24 6:48 PM
 */
@Data
public class PurchaseDoneVo {

    @NotNull
    private Long id;

    private List< PurchaseDoneItemVo> items;
}
