package io.hongting.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.hongting.common.utils.PageUtils;
import io.hongting.mall.product.entity.BrandEntity;

import java.util.Map;

/**
 * 品牌
 *
 * @author hongting
 * @email hongting828@gmail.com
 * @date 2021-06-18 21:16:17
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void updateDetail(BrandEntity brand);
}

