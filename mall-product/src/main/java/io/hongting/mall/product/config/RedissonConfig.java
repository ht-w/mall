package io.hongting.mall.product.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @author hongting
 * @create 2021 07 13 9:17 PM
 */

@Configuration
public class RedissonConfig {

    @Bean(destroyMethod = "shutdown")
    public RedissonClient redisson() throws IOException{
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.189.129:6379");
        return Redisson.create(config);
    }
}
