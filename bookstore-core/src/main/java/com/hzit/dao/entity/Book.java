package com.hzit.dao.entity;

/**
 * 
 * @author liuchao
 */
public class Book {
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
	 * 图书名称
	 * @param bookname
	 */
	public void setBookname(String bookname){
		this.bookname = bookname;
	}
	
    /**
     * 图书名称
     * @return
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
     * @return
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
     * @return
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
     * @return
     */	
    public String getBookpic(){
    	return bookpic;
    }
}