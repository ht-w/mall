package io.hongting.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.hongting.common.utils.PageUtils;
import io.hongting.mall.member.entity.MemberEntity;
import io.hongting.mall.member.vo.MemberLoginVo;
import io.hongting.mall.member.vo.MemberUserRegisterVo;
import io.hongting.mall.member.vo.SocialUser;

import java.util.Map;

/**
 * 会员
 *
 * @author hongting
 * @email hongting828@gmail.com
 * @date 2021-06-18 21:27:01
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void register(MemberUserRegisterVo vo);

    MemberEntity login(MemberLoginVo loginVo);

    MemberEntity login(SocialUser socialUser);
}

