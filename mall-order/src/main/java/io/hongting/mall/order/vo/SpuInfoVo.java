package io.hongting.mall.order.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author hongting
 * @create 2021 08 18 5:48 PM
 */
@Data
public class SpuInfoVo {

    private Long id;
    /**
     * 商品名称
     */
    private String spuName;
    /**
     * 商品描述
     */
    private String spuDescription;
    /**
     * 所属分类id
     */
    private Long catalogId;
    /**
     * 品牌id
     */
    private Long brandId;
    /**
     *
     */
    private BigDecimal weight;
    /**
     * 上架状态[0 - 下架，1 - 上架]
     */
    private Integer publishStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
