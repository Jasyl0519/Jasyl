package com.jason.controller;

import com.jason.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jason on 15/9/2.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "hello")
    public void hello() {
        System.out.println("hello world");
        /*User user = new User();
        user.setId(1l);
        user.setUsername("jason");
        user.setPassword("jason");*/
        Map map = new HashMap();
        map.put("username","jason");
        userService.select(map);

        //return "hi";
    }


    @RequestMapping(value = "/login/{user}", method = RequestMethod.GET)
    public ModelAndView myMethod(HttpServletRequest request,HttpServletResponse response,
                                 @PathVariable("user") String user, ModelMap modelMap) throws Exception {
        modelMap.put("loginUser", user);
        return new ModelAndView("/login/hello", modelMap);
    }
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String registPost() {
        System.out.println("hello world");

        return "/welcome";
    }
}
