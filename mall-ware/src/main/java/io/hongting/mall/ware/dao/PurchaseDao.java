package io.hongting.mall.ware.dao;

import io.hongting.mall.ware.entity.PurchaseEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 采购信息
 * 
 * @author hongting
 * @email hongting@gmail.com
 * @date 2021-06-18 21:11:17
 */
@Mapper
public interface PurchaseDao extends BaseMapper<PurchaseEntity> {
	
}
