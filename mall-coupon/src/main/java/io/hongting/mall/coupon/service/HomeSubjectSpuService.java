package io.hongting.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.hongting.common.utils.PageUtils;
import io.hongting.mall.coupon.entity.HomeSubjectSpuEntity;

import java.util.Map;

/**
 * δΈι’εε
 *
 * @author hongting
 * @email hongting828@gmail.com
 * @date 2021-06-18 21:23:30
 */
public interface HomeSubjectSpuService extends IService<HomeSubjectSpuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

