package com.hibernate.hibernateLearning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Embed {
	
	public static void main(String[] args) {
		SessionFactory factory= new Configuration().configure().buildSessionFactory();
		Student student = new Student();
		student.setId(3);
		student.setName("Cerificate");
		student.setCity("Online");
		Certificate certi = new Certificate("Hibernate","50hrs");
		student.setCerti(certi);
		Student student1 = new Student(1,"Reshma","Manali");
		student1.setCerti(new Certificate("Java","60 days"));
		Session session = (Session) factory.openSession();
    	session.beginTransaction();
    	session.save(student);
    	session.save(student1);
    	session.getTransaction().commit();
    	System.out.println(session.get(Student.class, 3));
		session.close();
		factory.close();
	}

}
