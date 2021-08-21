package io.hongting.mall.ware.dao;

import io.hongting.mall.ware.entity.WareInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 仓库信息
 * 
 * @author hongting
 * @email hongting@gmail.com
 * @date 2021-06-18 21:11:17
 */
@Mapper
public interface WareInfoDao extends BaseMapper<WareInfoEntity> {
	
}
