package com.jagan.redis.springredis.service;

import com.jagan.redis.springredis.model.User;

public interface UserService {

    User saveUser(User user);

    User findUserById(String userId);


}
