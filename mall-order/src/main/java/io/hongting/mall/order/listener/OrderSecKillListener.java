package io.hongting.mall.order.listener;

import com.rabbitmq.client.Channel;
import io.hongting.common.to.mq.SeckillOrderTo;
import io.hongting.mall.order.service.OrderService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author hongting
 * @create 2021 08 18 5:40 PM
 */
@RabbitListener(queues = "order.seckill.order.queue")
@Component
public class OrderSecKillListener {

    @Autowired
    private OrderService orderService;

    @RabbitHandler
    public void listener(SeckillOrderTo secKillOrderTo, Channel channel, Message message) throws IOException {
        try {
            // 创建秒杀单的信息
            orderService.createSecKillOrder(secKillOrderTo);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        } catch (Exception e) {
            channel.basicReject(message.getMessageProperties().getDeliveryTag(),true);
        }
    }
}
