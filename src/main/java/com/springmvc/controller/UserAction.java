package com.springmvc.controller;

import com.springmvc.model.User;
import com.springmvc.service.UserService;
import com.utils.BasePageResult;
import com.utils.Page;
import com.utils.ResultSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class UserAction extends Page{

    @Resource
    private UserService userService;

    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return "hello world";
    }

    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable int id){
        return userService.getUser(id);
    }

    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    @ResponseBody
    public BasePageResult getAllUser(int pageSize, int pageNo){
        BasePageResult result = new BasePageResult();
        result.setList(userService.selectAll(pageNo, pageSize));
        return result;
    }
}