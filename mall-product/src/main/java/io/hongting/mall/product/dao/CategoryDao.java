package io.hongting.mall.product.dao;

import io.hongting.mall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author hongting
 * @email hongting828@gmail.com
 * @date 2021-06-18 21:16:17
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
