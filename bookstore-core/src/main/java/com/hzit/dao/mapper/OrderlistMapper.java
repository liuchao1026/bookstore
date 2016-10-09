package com.hzit.dao.mapper;

import java.util.List;
import java.util.Map;

import com.hzit.dao.vo.OrderlistVo;
import org.apache.ibatis.annotations.Param;
import com.hzit.dao.entity.Orderlist;
import com.fc.platform.commons.page.Page;
import com.fc.platform.commons.page.Pageable;

public interface OrderlistMapper {

	void insertOrderlist(Orderlist orderlist);

	void deleteOrderlistByOrderid(Integer orderid);

	void updateOrderlist(Orderlist orderlist);

	Page<Orderlist> searchOrderlistByParams(@Param("map") Map<String, String> map, Pageable pageable);

	List<Orderlist> searchOrderlistByParams(@Param("map") Map<String, String> map);

	OrderlistVo findbyid(@Param("userid") int userid);
} 
