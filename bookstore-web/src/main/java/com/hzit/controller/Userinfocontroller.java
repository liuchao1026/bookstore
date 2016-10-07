package com.hzit.controller;

import com.hzit.dao.entity.Userinfo;
import com.hzit.service.Userinfoservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/10/6.
 */
@Controller
public class Userinfocontroller {
    @Autowired
    private Userinfoservice userinfoservice;

    @RequestMapping("/denglu")
    public String login(String username,String userpwd){
      List<Userinfo> list= userinfoservice.find(username,userpwd);
        return "zhuye";
    }


    @RequestMapping("/adduser")
    @ResponseBody
    public String adduser(ModelMap modelMap,Userinfo userinfo){
        userinfoservice.add(userinfo);
        modelMap.put("userinfo",userinfo);
        return "rs";
    }


}
