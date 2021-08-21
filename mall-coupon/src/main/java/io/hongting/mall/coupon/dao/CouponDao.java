package io.hongting.mall.coupon.dao;

import io.hongting.mall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author hongting
 * @email hongting828@gmail.com
 * @date 2021-06-18 21:23:30
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
