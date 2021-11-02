package com.spring.SpringJdbc;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.SpringJdbc.dao.StudentDao;
import com.spring.SpringJdbc.entities.Student;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		System.out.println("My Application Started...");
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/SpringJdbc/Config.xml");
		StudentDao studentDao = context.getBean("studentDaoImpl",StudentDao.class);
		Student student = new Student(222,"Ankit","Chadigarh");
		System.out.println("Number of records inserted "+studentDao.insert(student));
		student.setId(222);
		student.setName("Ankit Vashisth");
		student.setCity("Faridabad");
		System.out.println("Number of records updated "+studentDao.updateValues(student));
		System.out.println("Number of records deleted "+studentDao.delete(222));
		//SpringApplication.run(SpringJdbcApplication.class, args);
	}

}
