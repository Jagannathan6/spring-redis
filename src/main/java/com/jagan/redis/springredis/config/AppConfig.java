package com.jagan.redis.springredis.config;

import com.jagan.redis.springredis.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@Slf4j
public class AppConfig {

    @Value("${redis.host}")
    private String host;

    @Value("${redis.port}")
    private int port;

    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory jedisConFactory
                = new JedisConnectionFactory();
        jedisConFactory.setHostName("localhost");
        jedisConFactory.setPort(6379);
        return jedisConFactory;
    }


    @Bean
    RedisTemplate<String, User> redisTemplate() {
        RedisTemplate<String, User> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new
                Jackson2JsonRedisSerializer<>(User.class));
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        return redisTemplate;
    }

}
