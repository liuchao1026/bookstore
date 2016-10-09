package com.hzit.dao.entity;

/**
 * 
 * @author liuchao
 */
public class Orderlist {
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
	public void setOrderid(String orderid){
		this.orderid = orderid;
	}
	
    /**
     * 订单id
     * @return
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
     * @return
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
     * @return
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
     * @return
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
     * @return
     */	
    public String getOrderprice(){
    	return orderprice;
    }
}