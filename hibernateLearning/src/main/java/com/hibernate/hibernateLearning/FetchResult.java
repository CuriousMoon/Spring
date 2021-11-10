package com.hibernate.hibernateLearning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchResult {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		//If data does not exists then load throws org.hibernate.ObjectNotFoundException
		Student student1 = (Student)session.load(Student.class,10);
		//If data does not exists then get returns null
		Student student2 = (Student)session.get(Student.class,10);
		System.out.println(student1);
		System.out.println(student2);
		session.close();
		factory.close();
	}

}
