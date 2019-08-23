package com.zyj.test.HibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import com.zyj.jfcs.app.model.Calcresult;
import com.zyj.jfcs.app.model.User;

public class Demo01 {
	private static SessionFactory sessionFactory;
	public static void main(String[] args) {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata(registry).buildSessionFactory();
			
		} catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
			e.printStackTrace();
		}
		
//		addItem();
//		selectItems();
		
		addUser();
		selectUser();
	}
	
	private static void selectUser() {
		Session session = sessionFactory.openSession();
		Query<User> query = session.createQuery("from User where userName = :userName");
		query.setParameter("userName", "zyj");
		User user = query.uniqueResult();
		System.out.println(user.getUserName());
		System.out.println(user.getPassword());
		session.close();
	}
	private static void addUser() {
		User user =new User();
		user.setUserName("zyj");
		user.setPassword("zyj");
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		
		session.save(user);
		t.commit();
//		session.flush();
		session.close();
	}
	
	private static void selectItems() {
		Session session = sessionFactory.openSession();
		Item item = session.createQuery("from Item where id = 1", Item.class).uniqueResult();
		System.out.println(item.getName());
	}
	
	private static void addItem() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Item item = new Item();
		item.setId(1L);
		item.setName("语文");
		session.save(item);
		
		session.save(new Calcresult());
		
		transaction.commit();
	}
}
