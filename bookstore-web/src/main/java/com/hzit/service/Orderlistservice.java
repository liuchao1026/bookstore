package com.hzit.service;

import com.fc.platform.commons.page.Page;
import com.hzit.dao.entity.Orderlist;
import com.hzit.dao.vo.OrderlistVo;

/**
 * Created by Administrator on 2016/10/8.
 */
public interface Orderlistservice {
    boolean addorder(OrderlistVo orderlistVo);
    Page<Orderlist>  findbypage(int page,int currline);
    OrderlistVo findbyid(int userid);
}
