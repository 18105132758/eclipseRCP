package com.zyj.jfcs.app.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * 教学单位
 * @author zhouyj
 *
 */
public class TeachUnit {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment" , strategy = "increment")
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
