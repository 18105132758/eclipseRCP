package com.zyj.jfcs.app.model;
/**
 * 用户登录对象，临时保存用户的登录信息，方便登陆以后处理用户信息
 * @author 周昱君
 *
 */
public class SaveLogInfo {
	private static SaveLogInfo INSTANCE = new SaveLogInfo();
	
	private String username;
	
	private String password;
	
	private String usertag;

	
	
	/**
	 * 构造私有化，使用单例模式
	 */
	private SaveLogInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public static SaveLogInfo getINSTANCE() {
		return INSTANCE;
	}
	
	
	
	
}
