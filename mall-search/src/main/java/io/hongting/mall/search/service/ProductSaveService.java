package io.hongting.mall.search.service;

import io.hongting.common.to.es.SkuEsModel;

import java.io.IOException;
import java.util.List;

/**
 * @author hongting
 * @create 2021 06 28 7:29 PM
 */
public interface ProductSaveService {


    boolean productStatusUp(List<SkuEsModel> skuEsModels) throws IOException;

}
