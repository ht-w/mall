package io.hongting.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.hongting.common.utils.PageUtils;
import io.hongting.mall.product.entity.SpuImagesEntity;
import io.hongting.mall.product.entity.SpuInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * spu图片
 *
 * @author hongting
 * @email hongting828@gmail.com
 * @date 2021-06-18 21:17:13
 */
public interface SpuImagesService extends IService<SpuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);


    void saveImages(List<String> images, Long id);
}

