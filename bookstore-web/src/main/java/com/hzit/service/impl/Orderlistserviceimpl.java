package com.hzit.service.impl;

import com.hzit.dao.entity.Book;
import com.hzit.dao.entity.Orderdetail;
import com.hzit.dao.entity.Orderlist;
import com.hzit.dao.mapper.OrderdetailMapper;
import com.hzit.dao.mapper.OrderlistMapper;
import com.hzit.dao.vo.BookVo;
import com.hzit.dao.vo.OrderlistVo;
import com.hzit.service.Orderlistservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
