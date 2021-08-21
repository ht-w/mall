package io.hongting.mall.member.dao;

import io.hongting.mall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author hongting
 * @email hongting828@gmail.com
 * @date 2021-06-18 21:27:01
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
