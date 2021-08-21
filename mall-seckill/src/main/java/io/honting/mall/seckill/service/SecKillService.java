package io.honting.mall.seckill.service;

import io.honting.mall.seckill.to.SeckillSkuRedisTo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author hongting
 * @create 2021 08 18 12:05 PM
 */

public interface SecKillService {

    void uploadSeckillSkuLatest3Days();

    List<SeckillSkuRedisTo> getCurrentSeckillSkus();

    SeckillSkuRedisTo getSeckillSkuInfo(Long skuId);

    String kill(String killId, String key, Integer num) throws InterruptedException;
}
