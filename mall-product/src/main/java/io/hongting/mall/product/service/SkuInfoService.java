package io.hongting.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.hongting.common.utils.PageUtils;
import io.hongting.mall.product.entity.SkuInfoEntity;
import io.hongting.mall.product.vo.SkuItemVo;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * sku信息
 *
 * @author hongting
 * @email hongting828@gmail.com
 * @date 2021-06-18 21:16:17
 */
public interface SkuInfoService extends IService<SkuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<SkuInfoEntity> getSkusBySpuId(Long spuId);

    void saveSkuInfo(SkuInfoEntity skuInfoEntity);

    SkuItemVo item(Long skuId) throws ExecutionException, InterruptedException;
}

