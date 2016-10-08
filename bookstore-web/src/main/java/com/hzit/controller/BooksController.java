package com.hzit.controller;

import com.fc.platform.commons.page.Page;
import com.hzit.dao.entity.Book;
import com.hzit.dao.vo.BookVo;
import com.hzit.service.Booksservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


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
    * 购物车
    *
    * 拿到数据，遍历循环封装到BOOKVO然后封装到map,再到session
    *  以便于页面输出
    * */
    @RequestMapping("/shopping")
     public String selectById(@RequestParam("bookid")String[] ints,HttpSession session){

        Map bookvomap=(Map)session.getAttribute("bookvomap");
        if (bookvomap==null){
            bookvomap=new HashMap();
            session.setAttribute("bookvomap",bookvomap);
        }
        for (int i=1;i<=ints.length;i++){
            Book book=booksservice.selectById(Integer.parseInt(ints[i - 1]));
            BookVo bookVo=new BookVo();
            bookVo.setBookcount(book.getBookcount());
            bookVo.setBookid(book.getBookid());
            bookVo.setBookname(book.getBookname());
            bookVo.setBookpic(book.getBookpic());
            bookVo.setBookprice(book.getBookprice());
            BookVo bookVo1=(BookVo)bookvomap.get(book.getBookid());
            if(bookVo1!=null){
                bookVo.setCount(bookVo1.getCount()+1);
            }
            else
                bookVo.setCount(1);

            bookvomap.put(book.getBookid(),bookVo);

        }

        session.setAttribute("bookvomap",bookvomap);

        return "redirect:/book/toshopping";

    }

    /*
    *
    *
    *为了防止刷新时购买的图书数量增加，来一个中间跳转
    *
    * */

    @RequestMapping("/toshopping")
    public String jumpToshopping(){
        return "shopping";
    }
}
