package io.hongting.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.hongting.common.utils.PageUtils;
import io.hongting.mall.order.entity.OrderSettingEntity;

import java.util.Map;

/**
 * 订单配置信息
 *
 * @author hongting
 * @email hongting828@gmail.com
 * @date 2021-06-18 21:21:52
 */
public interface OrderSettingService extends IService<OrderSettingEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

