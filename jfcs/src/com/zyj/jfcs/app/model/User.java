package com.zyj.jfcs.app.model;
/**
 * 	用户实体
 * @author zhouyj
 */
public class User {
	private int id;
	
	private String userName;
	
	private String password;
	
	private String usertag;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsertag() {
		return usertag;
	}

	public void setUsertag(String usertag) {
		this.usertag = usertag;
	}
	
}
