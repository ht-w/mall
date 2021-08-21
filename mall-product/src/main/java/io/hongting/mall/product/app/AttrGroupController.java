package io.hongting.mall.product.app;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


import io.hongting.mall.product.entity.AttrEntity;
import io.hongting.mall.product.service.AttrAttrgroupRelationService;
import io.hongting.mall.product.service.AttrService;
import io.hongting.mall.product.service.CategoryService;
import io.hongting.mall.product.vo.AttrGroupRelationVo;
import io.hongting.mall.product.vo.AttrGroupWithAttrsVo;
import org.springframework.web.bind.annotation.*;

import io.hongting.mall.product.entity.AttrGroupEntity;
import io.hongting.mall.product.service.AttrGroupService;
import io.hongting.common.utils.PageUtils;
import io.hongting.common.utils.R;

import javax.annotation.Resource;


/**
 * 属性分组
 *
 * @author hongting
 * @email hongting828@gmail.com
 * @date 2021-06-18 21:16:17
 */
@RestController
@RequestMapping("product/attrgroup")
public class AttrGroupController {
    @Resource
    private AttrGroupService attrGroupService;

    @Resource
    private CategoryService categoryService;

    @Resource
    private AttrService attrService;

    @Resource
    private AttrAttrgroupRelationService attrAttrgroupRelationService;

    @GetMapping("/{catelogId}/withattr")
    public R getAttrGroupWithAttrs(@PathVariable ("catelogId") Long catelogId){
        List <AttrGroupWithAttrsVo> data = attrGroupService.getAttrGroupWithAttrsByCatelogId(catelogId);
        return R.ok().put("data", data);
    }


    @PostMapping("/attr/relation")
    public R addRelation(@RequestBody List<AttrGroupRelationVo> relationVos){
        attrAttrgroupRelationService.saveBatch(relationVos);
        return R.ok();
    }

    @GetMapping("/{attrgroupId}/attr/relation")
    public R attrRelation (@PathVariable("attrgroupId") Long attrgroupId){
        List<AttrEntity> entities = attrService.getRelationAttr(attrgroupId);
        return R.ok().put("data", entities);

    }

    @GetMapping("{attrgroupId/noattr/relation")
    public R attrNoRelation(@PathVariable("attrgroupId") long attrgroupId, @RequestParam Map<String,Object> params){
        PageUtils page = attrService.getNoRelationAttr(params,attrgroupId);
        return R.ok().put("page", page);
    }

    @PostMapping ("/attr/relation/delete")
    public R deleteRelation (@RequestBody AttrGroupRelationVo [] attrGroupRelationVos){
        attrService.deleteRelation(attrGroupRelationVos);
        return R.ok();
    }

    /**
     * 列表
     */
    @RequestMapping("/list/{catelogId}")
   // @RequiresPermissions("product:attrgroup:list")
    public R list(@RequestParam Map<String, Object> params , @PathVariable ("catelogId") Long cateLogId){
        PageUtils page = attrGroupService.queryPage(params, cateLogId);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrGroupId}")
   // @RequiresPermissions("product:attrgroup:info")
    public R info(@PathVariable("attrGroupId") Long attrGroupId){
		AttrGroupEntity attrGroup = attrGroupService.getById(attrGroupId);
        Long catelogId = attrGroup.getCatelogId();
        Long [] path = categoryService.getCatalogPath(catelogId);
		attrGroup.setCatelogPath(path);
        return R.ok().put("attrGroup", attrGroup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
   // @RequiresPermissions("product:attrgroup:save")
    public R save(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.save(attrGroup);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:attrgroup:update")
    public R update(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.updateById(attrGroup);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
   // @RequiresPermissions("product:attrgroup:delete")
    public R delete(@RequestBody Long[] attrGroupIds){
		attrGroupService.removeByIds(Arrays.asList(attrGroupIds));

        return R.ok();
    }

}
