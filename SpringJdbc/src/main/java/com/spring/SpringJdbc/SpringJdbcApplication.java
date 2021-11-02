package com.spring.SpringJdbc;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		System.out.println("My Application Started...");
		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/SpringJdbc/Config.xml");
		JdbcTemplate template = context.getBean("jdbcTemplate",JdbcTemplate.class);
		
		//Insert Query
		String query = "insert into student(id,name,city) values(?,?,?)";
		
		//Execute query
		int result = template.update(query, 333,"Raghav","Noida");
		System.out.println("Number of records inserted "+result);
		//SpringApplication.run(SpringJdbcApplication.class, args);
	}

}
