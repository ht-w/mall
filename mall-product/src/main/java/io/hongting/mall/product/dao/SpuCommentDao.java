package io.hongting.mall.product.dao;

import io.hongting.mall.product.entity.SpuCommentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价
 * 
 * @author hongting
 * @email hongting828@gmail.com
 * @date 2021-06-18 21:17:13
 */
@Mapper
public interface SpuCommentDao extends BaseMapper<SpuCommentEntity> {
	
}
