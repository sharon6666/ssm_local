package com.ssm.controller;

import com.ssm.model.User;
import com.ssm.redis.RedisUtils;
import com.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @Resource(name = "redisUtils")
    private RedisUtils redisUtils;

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "hello world";
    }

    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUser() {
        if (redisUtils.get("allUser") == null) {
            redisUtils.set("allUser", userService.selectAll().toString());
        }
        return userService.selectAll();
    }
}