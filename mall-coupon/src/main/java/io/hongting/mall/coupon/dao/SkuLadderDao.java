package io.hongting.mall.coupon.dao;

import io.hongting.mall.coupon.entity.SkuLadderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品阶梯价格
 * 
 * @author hongting
 * @email hongting828@gmail.com
 * @date 2021-06-18 21:24:38
 */
@Mapper
public interface SkuLadderDao extends BaseMapper<SkuLadderEntity> {
	
}
