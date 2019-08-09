package com.zyj.test.HibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

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
		selectItems();
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
		transaction.commit();
	}
}
