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
import java.util.Collection;
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
    public String selectByPage(@RequestParam (name = "page",defaultValue ="1")int page,@RequestParam(name = "totalpages" ,defaultValue = "1") int totalpages,ModelMap modelMap){
        if (page <= 1) {
            page = 1;
        }
        if (page >= totalpages) {
            page = totalpages;
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
        /*String totalprice=(String)session.getAttribute("totalprice");
        if (totalprice==null){
            totalprice="0";
            session.setAttribute("totalprice",totalprice);
        }
        int sum=Integer.parseInt(totalprice);*/


//        int sum=(Integer)session.getAttribute("totalprice");

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

            //总价算出来
//            sum+=bookVo.getCount()*Integer.parseInt(bookVo.getBookprice());

            bookvomap.put(book.getBookid(),bookVo);

        }

        session.setAttribute("bookvomap",bookvomap);
//        session.setAttribute("totalprice",sum);

//        modelMap.put("totalprice",sum);

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
    /*
    *
    * 跟新购物车里面的数据，且返回总价
    * */
    @RequestMapping("/updateshopping")
    @ResponseBody
    public Object updatebookvo(@RequestParam("bookid") int bookid,@RequestParam("count") int count,HttpSession session){
        System.out.println("正在修改"+bookid+"号");
        Map map=(Map)session.getAttribute("bookvomap");
        BookVo bookVo=(BookVo)map.get(bookid);
        bookVo.setCount(count);
        //计算图书总价
        int sum=0;
        Collection<BookVo> collection=map.values();
        for (BookVo b:collection){
            sum+=b.getCount()*Integer.parseInt(b.getBookprice());
        }

        return sum;

    }
    /*
    *
    * 删除购物车里面的数据,同样返回一个总价
    * */
    @RequestMapping("/deletebookvo")
    @ResponseBody
    public Object deleteBookVo(@RequestParam("bookid") int bookid,HttpSession session){
        System.out.println("正在删除几号"+bookid);
            Map bookvomap=(Map)session.getAttribute("bookvomap");
                bookvomap.remove(bookid);
        //计算图书总价
        int sum=0;
        Collection<BookVo> collection=bookvomap.values();
        for (BookVo b:collection){
            sum+=b.getCount()*Integer.parseInt(b.getBookprice());
        }

        return sum;

    }


 }
