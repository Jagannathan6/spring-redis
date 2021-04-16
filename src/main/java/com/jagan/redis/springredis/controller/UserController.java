package com.jagan.redis.springredis.controller;

import com.jagan.redis.springredis.model.User;
import com.jagan.redis.springredis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public User save(@RequestBody User user) {
        log.info("Saving User");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        return userService.findUserById(id);
    }
}
