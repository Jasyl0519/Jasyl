package com.jason.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jason on 16/4/5.
 */

@Controller
@RequestMapping("/pub/jason")
public class JasonTest {

    @RequestMapping(value = "sylvia_sb")
    @ResponseBody
    public String test() {


        String str = "sylvia is a pig";
        return str;

    }
}
