package com.hzit.dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import com.hzit.dao.entity.Orderdetail;
import com.fc.platform.commons.page.Page;
import com.fc.platform.commons.page.Pageable;

public interface OrderdetailMapper {

	void insertOrderdetail(Orderdetail orderdetail);

	void deleteOrderdetailById(Integer id);

	void updateOrderdetail(Orderdetail orderdetail);

	Page<Orderdetail> searchOrderdetailByParams(@Param("map") Map<String, String> map, Pageable pageable);

	List<Orderdetail> searchOrderdetailByParams(@Param("map") Map<String, String> map);

} 
