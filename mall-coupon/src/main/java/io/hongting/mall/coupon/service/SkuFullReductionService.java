package io.hongting.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.hongting.common.to.SkuReductionTo;
import io.hongting.common.utils.PageUtils;
import io.hongting.mall.coupon.entity.SkuFullReductionEntity;

import java.util.Map;

/**
 * 商品满减信息
 *
 * @author hongting
 * @email hongting828@gmail.com
 * @date 2021-06-18 21:24:38
 */
public interface SkuFullReductionService extends IService<SkuFullReductionEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveSkuReduction(SkuReductionTo reductionTo);
}

