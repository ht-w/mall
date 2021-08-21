package io.hongting.mall.product.vo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author hongting
 * @create 2021 07 20 2:26 PM
 */
@Data
@ToString
public class SpuItemAttrGroupVo {

    private String groupName;

    private List<Attr> attrs;

}

