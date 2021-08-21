package io.hongting.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.hongting.common.utils.PageUtils;
import io.hongting.mall.order.entity.OrderOperateHistoryEntity;

import java.util.Map;

/**
 * 订单操作历史记录
 *
 * @author hongting
 * @email hongting828@gmail.com
 * @date 2021-06-18 21:21:52
 */
public interface OrderOperateHistoryService extends IService<OrderOperateHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

