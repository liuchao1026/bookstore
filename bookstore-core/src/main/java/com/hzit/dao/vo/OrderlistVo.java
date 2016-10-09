package com.hzit.dao.vo;

import java.util.List;

/**
 * 
 * @author liuchao
 */
public class OrderlistVo {
	/**
	 *  订单id
	 */
	private String orderid;
	/**
	 *  用户id
	 */
	private Integer userid;
	/**
	 *  订单创建时间
	 */
	private java.util.Date ordertime;
	/**
	 *  订单状态
	 */
	private String orderstate;
	/**
	 *  订单价格
	 */
	private String orderprice;
	/**
	 * 订单id
	 * @param orderid
	 */

	/**
	 * 订单中所有购买的图书集合
	 * @param orderid
	 */
	private List<BookVo> bookVoList;

	public List<BookVo> getBookVoList() {
		return bookVoList;
	}

	public void setBookVoList(List<BookVo> bookVoList) {
		this.bookVoList = bookVoList;
	}

	public void setOrderid(String orderid){
		this.orderid = orderid;
	}
	
    /**
     * 订单id
     * @return Integer
     */	
    public String getOrderid(){
    	return orderid;
    }
	/**
	 * 用户id
	 * @param userid
	 */
	public void setUserid(Integer userid){
		this.userid = userid;
	}
	
    /**
     * 用户id
     * @return Integer
     */	
    public Integer getUserid(){
    	return userid;
    }
	/**
	 * 订单创建时间
	 * @param ordertime
	 */
	public void setOrdertime(java.util.Date ordertime){
		this.ordertime = ordertime;
	}
	
    /**
     * 订单创建时间
     * @return java.util.Date
     */	
    public java.util.Date getOrdertime(){
    	return ordertime;
    }
	/**
	 * 订单状态
	 * @param orderstate
	 */
	public void setOrderstate(String orderstate){
		this.orderstate = orderstate;
	}
	
    /**
     * 订单状态
     * @return String
     */	
    public String getOrderstate(){
    	return orderstate;
    }
	/**
	 * 订单价格
	 * @param orderprice
	 */
	public void setOrderprice(String orderprice){
		this.orderprice = orderprice;
	}
	
    /**
     * 订单价格
     * @return String
     */	
    public String getOrderprice(){
    	return orderprice;
    }
}