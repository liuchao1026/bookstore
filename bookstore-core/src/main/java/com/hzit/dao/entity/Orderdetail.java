package com.hzit.dao.entity;

/**
 * 
 * @author liuchao
 */
public class Orderdetail {
	/**
	 *  订单详情主键id
	 */
	private Integer id;
	/**
	 *  订单id
	 */
	private String orderid;
	/**
	 *  图书id
	 */
	private Integer bookid;
	/**
	 *  购买数量
	 */
	private String count;
	/**
	 *  交易金额
	 */
	private String tradeprice;
	/**
	 * 订单详情主键id
	 * @param id
	 */
	public void setId(Integer id){
		this.id = id;
	}
	
    /**
     * 订单详情主键id
     * @return
     */	
    public Integer getId(){
    	return id;
    }
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
	 * 图书id
	 * @param bookid
	 */
	public void setBookid(Integer bookid){
		this.bookid = bookid;
	}
	
    /**
     * 图书id
     * @return
     */	
    public Integer getBookid(){
    	return bookid;
    }
	/**
	 * 购买数量
	 * @param count
	 */
	public void setCount(String count){
		this.count = count;
	}
	
    /**
     * 购买数量
     * @return
     */	
    public String getCount(){
    	return count;
    }
	/**
	 * 交易金额
	 * @param tradeprice
	 */
	public void setTradeprice(String tradeprice){
		this.tradeprice = tradeprice;
	}
	
    /**
     * 交易金额
     * @return
     */	
    public String getTradeprice(){
    	return tradeprice;
    }
}