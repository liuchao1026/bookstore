package com.hzit.controller;

import com.hzit.dao.entity.Userinfo;
import com.hzit.dao.vo.BookVo;
import com.hzit.dao.vo.OrderlistVo;
import com.hzit.service.Orderlistservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/8.
 */
@Controller
public class Ordercontroller extends Basecontroller{
    @Autowired
    Orderlistservice orderlistservice;

    @RequestMapping("addorder")
    @ResponseBody
    public Object add(HttpSession session){
      try{
            //从session中获取用户对象、购物车
          Userinfo userinfo=(Userinfo)session.getAttribute("userinfo");
          Map bookvomap= (Map)session.getAttribute("bookvomap");
          //从购物车中获取所有的值,并转移到集合中，以便于放入到订单对象中
          Collection<BookVo> value=bookvomap.values();
          List list=new ArrayList();
        for (BookVo bookVo:value){
            list.add(bookVo);
        }
          OrderlistVo o= new OrderlistVo();
          o.setUserid(userinfo.getUserid());
          o.setBookVoList(list);
          boolean boo = orderlistservice.addorder(o);
          return boo;
      }catch (Exception e){
          e.printStackTrace();
            return false;
      }

    }
}
