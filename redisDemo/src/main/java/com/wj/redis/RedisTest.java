package com.wj.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RestController;

/**
 * redis
 * created 2018-03-26 16:53
 *
 * @author 吴健
 */

@RestController
@Slf4j
public class RedisTest {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public void delete() {
        redisTemplate.execute((RedisCallback<Object>) connection -> {
            connection.flushDb();
            log.info("flush success");
            return "flush success";
        });
    }


}
