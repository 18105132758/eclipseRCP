package com.zyj.jfcs.app.db.factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
/**
 * Hibernate session工厂实例
 * @author zhouyj
 *
 */
public class HibernateSessionFactory {
	/**
	 * Session缓存，每个线程都拥有独立的session实例
	 */
	private static final ThreadLocal<Session> sessionLocal = new ThreadLocal<Session>();
	
	/**
	 * Session工厂
	 */
	private static SessionFactory sessionFactory;
	
	
	public static void init(){
		//注册“服务”
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		//构建session工厂
		sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
	}
	
	
	
	
	private HibernateSessionFactory() {
		super();
	}

	/**
	 * 获取session实例
	 * @return
	 */
	public static Session getSession() {
		Session session = sessionLocal.get();
		if(session == null || session.isOpen()) {
			session = sessionFactory.openSession();
			sessionLocal.set(session);
		}
		return session;
	}
	
	/**
	 * 关闭session资源
	 */
	public static void closeSession() {
		Session session = sessionLocal.get();
		sessionLocal.remove();
		if(session != null) {
			session.close();
		}
	}
	
	
}
