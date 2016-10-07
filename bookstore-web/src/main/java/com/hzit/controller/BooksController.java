package com.hzit.controller;

import com.fc.platform.commons.page.Page;
import com.hzit.dao.entity.Book;
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
@RequestMapping("/book")
public class BooksController {
    @Autowired
    private  Booksservice booksservice;
    /*
    *
    * 通过页面查询book
    * */
    @RequestMapping("/selectbypage")
    public String selectByPage(@RequestParam (name = "page",defaultValue ="1")int page,@RequestParam(name = "totalpage" ,defaultValue = "2") int totalpage,ModelMap modelMap){
        if (page <= 1) {
            page = 1;
        }
        if (page >= totalpage) {
            page = totalpage;
        }

        Page<Book> pages=booksservice.selectByPage(page, 5);
        modelMap.put("pages",pages);
        modelMap.put("currpage", page);

       /* pages.getContent();
        pages.getTotalPages();*/
        return "index";
    }

    /*
    *
    * 通过bookid查询
    * */
    

}
