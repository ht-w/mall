package io.hongting.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.hongting.common.utils.PageUtils;
import io.hongting.mall.ware.entity.WareInfoEntity;
import io.hongting.mall.ware.vo.FareVo;

import java.util.Map;

/**
 * 仓库信息
 *
 * @author hongting
 * @email hongting@gmail.com
 * @date 2021-06-18 21:11:17
 */
public interface WareInfoService extends IService<WareInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    FareVo getFare(Long addrId);
}

