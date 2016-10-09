package com.hzit.controller;

import com.hzit.dao.entity.Userinfo;
import com.hzit.service.Userinfoservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2016/10/6.
 */
@Controller
public class Userinfocontroller extends Basecontroller{
    @Autowired
    private Userinfoservice userinfoservice;

    @RequestMapping("/denglu")
    public String login(@RequestParam("username") String username, @RequestParam("userpwd") String userpwd,HttpSession session){
      Userinfo userinfo= userinfoservice.findone(username,userpwd);
        if (userinfo==null){
            return "/login.html";
        }else {
        session.setAttribute("userinfo",userinfo);
            return "redirect:book/selectbypage";
        }

    }


    @RequestMapping("/adduser")

    public String adduser(ModelMap modelMap,Userinfo userinfo){
       boolean bo=userinfoservice.add(userinfo);
        modelMap.put("userinfo",userinfo);
      if (bo==true){
          return "register_success";
      }else {
          return "redirect:/login.html";
      }
    }


    @RequestMapping("/zhuxiao")
    public String loginout(HttpSession session){
            session.invalidate();
        return "redirect:/login.html";
    }

}
