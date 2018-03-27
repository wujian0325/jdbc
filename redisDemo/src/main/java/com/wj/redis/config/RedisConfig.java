package com.wj.redis.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * redis基本配置
 * created 2018-03-26 16:35
 *
 * @author 吴健
 */

@Configuration
public class RedisConfig {

    @Value(value = "${redis.host}")
    private String host;

    @Value(value = "${redis.port}")
    private int port;

    @Value(value = "${redis.password}")
    private String password;

    @Value(value = "${redis.index}")
    private int index;

    @Bean(name = "redisConnectionFactory")
    public RedisConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(host, port);
        configuration.setPassword(RedisPassword.of(password));
        configuration.setDatabase(index);
        return new JedisConnectionFactory(configuration);
    }

    @Bean
    public StringRedisTemplate redisTemplate(@Qualifier("redisConnectionFactory")RedisConnectionFactory factory) {
       return new StringRedisTemplate(factory);
    }
}
