package io.hongting.mall.order.dao;

import io.hongting.mall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author hongting
 * @email hongting828@gmail.com
 * @date 2021-06-18 21:21:52
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
