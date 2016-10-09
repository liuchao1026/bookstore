package com.hzit.service.impl;

import com.fc.platform.commons.page.Page;
import com.fc.platform.commons.page.PageRequest;
import com.hzit.dao.entity.Book;
import com.hzit.dao.entity.Orderdetail;
import com.hzit.dao.entity.Orderlist;
import com.hzit.dao.mapper.OrderdetailMapper;
import com.hzit.dao.mapper.OrderlistMapper;
import com.hzit.dao.vo.BookVo;
import com.hzit.dao.vo.OrderlistVo;
import com.hzit.service.Orderlistservice;
import com.sun.org.apache.bcel.internal.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2016/10/8.
 */
@Service
public class Orderlistserviceimpl implements Orderlistservice {
    @Autowired
    OrderlistMapper orderlistMapper;
    @Autowired
    OrderdetailMapper orderdetailMapper;

    //添加订单的时候要先添加订单再添加订单详情。
    @Override
    @Transactional  //添加事物支持。如果出现异常该方法的所有操作回滚
    public boolean addorder(OrderlistVo orderlistVo) {
        String orderId= UUID.randomUUID().toString();
        Orderlist orderlist=new Orderlist();
        orderlist.setOrderid(orderId);
        orderlist.setOrdertime(new Date());
        orderlist.setOrderstate("已下单");
        orderlist.setUserid(orderlistVo.getUserid());
        //因为订单的价格是总价所以要现货的单价跟数量
       List<BookVo> orderdetail= orderlistVo.getBookVoList();
        int sum=0;//声明一个总价
       for (BookVo b:orderdetail){
            sum+=b.getCount()*Integer.parseInt(b.getBookprice());
       }
        orderlist.setOrderprice(String.valueOf(sum));
        orderlistMapper.insertOrderlist(orderlist);
     //增加订单详情中的数据
        for (BookVo bx: orderdetail){
            sum+=bx.getCount()*Integer.parseInt(bx.getBookprice());
            Orderdetail odetail=new Orderdetail();
            odetail.setOrderid(orderId);
            odetail.setBookid(bx.getBookid());
            odetail.setCount(String.valueOf(bx.getCount()));
            odetail.setTradeprice(bx.getBookprice());
            orderdetailMapper.insertOrderdetail(odetail);

        }
        return true;
    }

    @Override
    public Page<Orderlist> findbypage(int page, int currline) {
        PageRequest pg=new PageRequest((page-1),currline);
         Page<Orderlist> p=orderlistMapper.searchOrderlistByParams(null,pg);
        return p;
    }

    @Override
    public OrderlistVo findbyid(int userid) {
        OrderlistVo ordervo=orderlistMapper.findbyid(userid);
        return ordervo;
    }
}
