package com.jagan.redis.springredis.service;

import com.jagan.redis.springredis.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    private HashOperations<String, Object, Object> hashOperations;

    @Autowired
    private RedisTemplate<String, User> redisTemplate;

    @PostConstruct
    private void initOperations() {
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public User saveUser(User user) {
        this.hashOperations.put("users", user.getId(), user);
        return user;
    }

    @Override
    public User findUserById(String userId) {
        log.info(" {}", userId);
        return (User) this.hashOperations.get("users", userId);
    }
}
