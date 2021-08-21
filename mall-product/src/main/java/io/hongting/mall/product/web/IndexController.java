package io.hongting.mall.product.web;

import io.hongting.mall.product.entity.CategoryEntity;
import io.hongting.mall.product.service.CategoryService;
import io.hongting.mall.product.vo.Catalogs2Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author hongting
 * @create 2021 07 13 8:34 AM
 */

@Controller
public class IndexController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping({"/","/index.html"})
    public String indexPage(Model model){
        List<CategoryEntity> categoryEntities  = categoryService.getLevel1Categories();
        model.addAttribute("categories", categoryEntities);
        return "index";
    }

    @ResponseBody
    @GetMapping("/index/catalog.json")
    public Map<String,List<Catalogs2Vo>>getCatalogJson(){
       return categoryService.getCatalogJson();
    }
}
