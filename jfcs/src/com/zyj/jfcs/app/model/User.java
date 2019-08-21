package com.zyj.jfcs.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 	用户实体
 * @author zhouyj
 */
@Entity
@Table(name = "JFCS_USER")
public class User {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment" , strategy = "increment")
	private int id;
	
	@Column(name = "USER_NAME", length = 100)
	private String userName;
	
	@Column(name = "PASSWORD", length = 100)
	private String password;
	
	@Column(name = "USER_TAG", length = 50)
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
