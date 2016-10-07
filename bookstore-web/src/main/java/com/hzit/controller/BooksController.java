package com.hzit.controller;

import com.hzit.service.Booksservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2016/10/7.
 */
@Controller
public class BooksController {
    @Autowired
    private  Booksservice booksservice;
    @RequestMapping("selectbypage")
    @ResponseBody
    public String selectbypage(@RequestParam (name = "page")String page,ModelMap modelMap){

        return "";
    }
}
