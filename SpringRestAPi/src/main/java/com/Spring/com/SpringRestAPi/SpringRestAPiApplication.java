package com.Spring.com.SpringRestAPi;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestAPiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestAPiApplication.class, args);
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
	}

}
