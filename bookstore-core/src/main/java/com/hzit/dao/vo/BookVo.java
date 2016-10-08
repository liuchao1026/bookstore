package com.hzit.dao.vo;

/**
 * 
 * @author liuchao
 */
public class BookVo {
	/**
	 *  图书id
	 */
	private Integer bookid;
	/**
	 *  图书名称
	 */
	private String bookname;
	/**
	 *  图书价格
	 */
	private String bookprice;
	/**
	 *  库存数量
	 */
	private String bookcount;
	/**
	 *  图书图片
	 */
	private String bookpic;
	/**
	 * 图书id
	 * @param bookid
	 */
	/*
	*购物单里购买的数量
	*
	* */

	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

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
	 * 图书名称
	 * @param bookname
	 */
	public void setBookname(String bookname){
		this.bookname = bookname;
	}
	
    /**
     * 图书名称
     * @return String
     */	
    public String getBookname(){
    	return bookname;
    }
	/**
	 * 图书价格
	 * @param bookprice
	 */
	public void setBookprice(String bookprice){
		this.bookprice = bookprice;
	}
	
    /**
     * 图书价格
     * @return String
     */	
    public String getBookprice(){
    	return bookprice;
    }
	/**
	 * 库存数量
	 * @param bookcount
	 */
	public void setBookcount(String bookcount){
		this.bookcount = bookcount;
	}
	
    /**
     * 库存数量
     * @return String
     */	
    public String getBookcount(){
    	return bookcount;
    }
	/**
	 * 图书图片
	 * @param bookpic
	 */
	public void setBookpic(String bookpic){
		this.bookpic = bookpic;
	}
	
    /**
     * 图书图片
     * @return String
     */	
    public String getBookpic(){
    	return bookpic;
    }
}