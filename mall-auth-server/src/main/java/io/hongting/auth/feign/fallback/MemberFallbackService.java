package io.hongting.auth.feign.fallback;

import io.hongting.auth.feign.MemberFeignService;
import io.hongting.auth.vo.SocialUser;
import io.hongting.auth.vo.UserLoginVo;
import io.hongting.auth.vo.UserRegisterVo;
import io.hongting.common.exception.BizCodeEnum;
import io.hongting.common.utils.R;
import org.springframework.stereotype.Service;

/**
 * @author hongting
 * @create 2021 08 17 1:03 PM
 */
@Service
public class MemberFallbackService implements MemberFeignService {
    @Override
    public R register(UserRegisterVo registerVo) {
        return R.error(BizCodeEnum.READ_TIME_OUT_EXCEPTION.getCode(), BizCodeEnum.READ_TIME_OUT_EXCEPTION.getMessage());
    }

    @Override
    public R login(UserLoginVo loginVo) {
        return R.error(BizCodeEnum.READ_TIME_OUT_EXCEPTION.getCode(), BizCodeEnum.READ_TIME_OUT_EXCEPTION.getMessage());
    }

    @Override
    public R login(SocialUser socialUser) {
        return R.error(BizCodeEnum.READ_TIME_OUT_EXCEPTION.getCode(), BizCodeEnum.READ_TIME_OUT_EXCEPTION.getMessage());
    }
}

