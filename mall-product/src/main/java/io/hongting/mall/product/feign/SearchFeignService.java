package io.hongting.mall.product.feign;

import io.hongting.common.to.es.SkuEsModel;
import io.hongting.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author hongting
 * @create 2021 06 28 8:02 PM
 */

@FeignClient("mall-search")
public interface SearchFeignService {

    @PostMapping("/search/save/product")
    R productStatusUp (@RequestBody List<SkuEsModel> skuEsModels);

}
