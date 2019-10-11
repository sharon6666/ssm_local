package com.ssm.controller;

import com.ssm.model.User;
import com.ssm.redis.RedisUtils;
import com.ssm.service.UserService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.nio.ByteBuffer;
import java.util.List;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @Resource(name = "redisUtils")
    private RedisUtils redisUtils;

    @RequestMapping("/")
    public String index() {
        return "hello world";
    }

    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @RequestMapping(value = "/getAllUser/{pageNo}/{pageSize}", method = RequestMethod.GET)
    public List<User> getAllUser(@PathVariable Integer pageNo, @PathVariable  Integer pageSize) {
        List<User> list = userService.selectAll(pageNo, pageSize);
        
        String f = "rfdstgf";
        f.length();
        list.size();
        return list;
    }

}