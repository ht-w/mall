package io.hongting.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.hongting.common.utils.PageUtils;
import io.hongting.mall.order.entity.PaymentInfoEntity;

import java.util.Map;

/**
 * 支付信息表
 *
 * @author hongting
 * @email hongting828@gmail.com
 * @date 2021-06-18 21:21:52
 */
public interface PaymentInfoService extends IService<PaymentInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

