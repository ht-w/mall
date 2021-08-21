package io.hongting.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.hongting.common.utils.PageUtils;
import io.hongting.mall.product.entity.CategoryEntity;
import io.hongting.mall.product.vo.Catalogs2Vo;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author hongting
 * @email hongting828@gmail.com
 * @date 2021-06-18 21:16:17
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listByTree();

    void removeByMenuIds(List<Long> catIds);

    Long[] getCatalogPath(Long catelogId);

    void updateCascade(CategoryEntity category);

    List<CategoryEntity> getLevel1Categories();

    Map<String, List<Catalogs2Vo>> getCatalogJsonFromDB();

    Map<String, List<Catalogs2Vo>> getCatalogJson();

    Map<String, List<Catalogs2Vo>> getCatalogJsonFromDbWithRedisLock();

    Map<String, List<Catalogs2Vo>> getCatalogJsonFromDbWithRedissonLock();
}

