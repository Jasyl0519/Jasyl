package com.jason.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import redis.clients.jedis.Jedis;

/**
 * Created by jason on 16/4/5.
 */

@Controller
@RequestMapping("/test")
public class JasonTest {

    @RequestMapping(value = "test")
    public String test(Model model) {


        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.set("name","jason");
        System.out.println(jedis.get("name"));

        model.addAttribute("a", jedis.get("name"));
        return "test";

    }


}
