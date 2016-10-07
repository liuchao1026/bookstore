package com.hzit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/10/6.
 */
@Controller
public class test {
    @RequestMapping("tologin")
    public String test(){
        System.out.println("方法被访问了");
        return "login";
    }
}
