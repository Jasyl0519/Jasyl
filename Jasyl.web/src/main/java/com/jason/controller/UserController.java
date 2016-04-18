package com.jason.controller;

import com.alibaba.fastjson.JSON;
import com.entity.UserVo;
import com.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by jason on 15/9/2.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping(value = "hello")
    public void hello() {
        System.out.println("hello world");

        UserVo userVo = userService.getUser(1);

        System.out.println(JSON.toJSON(userVo));
    }




}
