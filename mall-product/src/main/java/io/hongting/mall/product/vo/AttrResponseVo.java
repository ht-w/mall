package io.hongting.mall.product.vo;

import lombok.Data;

/**
 * @author hongting
 * @create 2021 06 23 7:02 AM
 */

@Data
public class AttrResponseVo extends AttrVo {

    private String groupName;

    private String catelogName;

    private Long [] path;
}
