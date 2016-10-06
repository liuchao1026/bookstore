package com.hzit.dao.entity;

/**
 * 
 * @author liuchao
 */
public class Userinfo {
	/**
	 *  用户ID
	 */
	private Integer userid;
	/**
	 *  用户名
	 */
	private String username;
	/**
	 *  用户密码
	 */
	private String userpwd;
	/**
	 *  用户邮箱
	 */
	private String useremail;
	/**
	 * 用户ID
	 * @param userid
	 */
	public void setUserid(Integer userid){
		this.userid = userid;
	}
	
    /**
     * 用户ID
     * @return
     */	
    public Integer getUserid(){
    	return userid;
    }
	/**
	 * 用户名
	 * @param username
	 */
	public void setUsername(String username){
		this.username = username;
	}
	
    /**
     * 用户名
     * @return
     */	
    public String getUsername(){
    	return username;
    }
	/**
	 * 用户密码
	 * @param userpwd
	 */
	public void setUserpwd(String userpwd){
		this.userpwd = userpwd;
	}
	
    /**
     * 用户密码
     * @return
     */	
    public String getUserpwd(){
    	return userpwd;
    }
	/**
	 * 用户邮箱
	 * @param useremail
	 */
	public void setUseremail(String useremail){
		this.useremail = useremail;
	}
	
    /**
     * 用户邮箱
     * @return
     */	
    public String getUseremail(){
    	return useremail;
    }
}