package io.hongting.mall.product.feign.fallback;

import io.hongting.common.exception.BizCodeEnum;
import io.hongting.common.utils.R;
import io.hongting.mall.product.feign.SeckillFeignService;
import org.springframework.stereotype.Component;

/**
 * @author hongting
 * @create 2021 08 18 1:53 PM
 */
@Component
public class SeckillFallbackService implements SeckillFeignService {
    @Override
    public R getSeckillSkuInfo(Long skuId) {
        return R.error(BizCodeEnum.READ_TIME_OUT_EXCEPTION.getCode(), BizCodeEnum.READ_TIME_OUT_EXCEPTION.getMessage());
    }
}
