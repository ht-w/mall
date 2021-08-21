package io.hongting.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.hongting.common.to.mq.SeckillOrderTo;
import io.hongting.common.utils.PageUtils;
import io.hongting.mall.order.entity.OrderEntity;
import io.hongting.mall.order.vo.OrderConfirmVo;
import io.hongting.mall.order.vo.OrderSubmitVo;
import io.hongting.mall.order.vo.SubmitOrderResponseVo;

import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * 订单
 *
 * @author hongting
 * @email hongting828@gmail.com
 * @date 2021-06-18 21:21:52
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);

    OrderConfirmVo confirmOrder() throws ExecutionException, InterruptedException;

    SubmitOrderResponseVo submitOrder(OrderSubmitVo submitVo);

    OrderEntity getOrderByOrderSn(String orderSn);

    void closeOrder(OrderEntity orderEntity);

    void createSecKillOrder(SeckillOrderTo secKillOrderTo);
}

