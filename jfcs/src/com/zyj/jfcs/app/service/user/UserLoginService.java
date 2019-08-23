package com.zyj.jfcs.app.service.user;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.zyj.jfcs.app.db.factory.HibernateSessionFactory;
import com.zyj.jfcs.app.model.User;

public class UserLoginService {
	/**
	 * 	用户登录
	 * @param userName	用户名
	 * @param password	密码
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean doLogin(String userName, String password) {
		if(StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
			System.out.println("用户名或密码不能为空！");
		}
		
		Session session = HibernateSessionFactory.getSession();
		Query<User> query = session.createQuery("from User where userName=:userName");	// and password=:password
		
		query.setParameter("userName", userName);
//		query.setParameter("password", password);
		
		User user = query.uniqueResult();
		if(user == null) {
			//新增
			user = new User();
			user.setUserName(userName);
			user.setUserName(password);
			addUser(user);
			return true;
		}
		
		if(password.equals(user.getPassword())) {
			//成功
			return true;
		}
		
		return false;
	}
	
	
	public void addUser(User newUser) {
		Session session = HibernateSessionFactory.getSession();
		
		Query<User> query = session.createQuery("from User where userName=:userName");	
		query.setParameter("userName", newUser.getUserName());
		if(query.getResultList().size() > 0) {
			//用户信息已经存在，方法结束
			return;
		}
		
		Transaction t = session.beginTransaction();
		session.save(newUser);
		t.commit();
		HibernateSessionFactory.closeSession();
	}
}
