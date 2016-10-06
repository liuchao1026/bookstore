package com.hzit.dao.vo;

/**
 * 
 * @author liuchao
 */
public class OrderdetailVo {
	/**
	 *  订单详情主键id
	 */
	private Integer id;
	/**
	 *  订单id
	 */
	private Integer orderid;
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
     * @return Integer
     */	
    public Integer getId(){
    	return id;
    }
	/**
	 * 订单id
	 * @param orderid
	 */
	public void setOrderid(Integer orderid){
		this.orderid = orderid;
	}
	
    /**
     * 订单id
     * @return Integer
     */	
    public Integer getOrderid(){
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
     * @return Integer
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
     * @return String
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
     * @return String
     */	
    public String getTradeprice(){
    	return tradeprice;
    }
}