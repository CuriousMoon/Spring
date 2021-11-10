package com.hibernate.hibernateLearning;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	public static void main(String[] args) {
		
		SessionFactory factory= new Configuration().configure().buildSessionFactory();
		Answer ans1 = new Answer();
		ans1.setAnswerId(101);
		ans1.setAnswer("Java is a programming language.");
		Question question1 = new Question();
		question1.setQuestionId(1);
		question1.setQuestion("What is java?");
		question1.setAnswer(ans1);
		
		Answer ans2 = new Answer();
		ans2.setAnswerId(102);
		ans2.setAnswer("API to work with group of objects.");
		Question question2 = new Question();
		question2.setQuestionId(2);
		question2.setQuestion("What is Collection Framework?");
		question2.setAnswer(ans2);
		
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(ans1);
		session.save(question1);
		session.save(ans2);
		session.save(question2);
		session.getTransaction().commit();
		System.out.println("Ques 1.) "+session.get(Question.class, 1).getQuestion()+"\nAns.)   "+session.get(Question.class, 1).getAnswer().getAnswer());
		session.close();
		factory.close();
	}
	
	
}
