package com.hibernate.hibernateLearning;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	//Reading Image
    	FileInputStream fis = new FileInputStream("src/main/java/Image.png");
    	byte[] data = new byte[fis.available()];
    	fis.read(data);
    	
    	//One session factory per project.It is thread safe.
    	SessionFactory factory= new Configuration().configure().buildSessionFactory();
    	Student student = new Student(3,"Shyam","Kasol");
    	System.out.println(student);
    	Address address = new Address();
    	address.setCity("Noida");
    	address.setStreet("DLF Phase 2");
    	address.setQuarantine(true);
    	address.setQuarantinedDate(new Date());
    	address.setX(0);
    	address.setImage(data);   	
    	System.out.println(address);
    	Session session = factory.openSession();
    	session.beginTransaction();
    	session.save(student);
    	session.save(address);
    	session.getTransaction().commit();
    	session.close();
    }
}
