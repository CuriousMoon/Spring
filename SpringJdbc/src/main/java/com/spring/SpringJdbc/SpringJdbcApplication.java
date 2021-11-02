package com.spring.SpringJdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.SpringJdbc.dao.StudentDao;
import com.spring.SpringJdbc.entities.Student;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) throws IOException {
		Student student;
		int id;
		String name, city,choice;
		System.out.println("My Application Started...");
		//To use for xml
//		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/SpringJdbc/Config.xml");
		//To use for annotations
		ApplicationContext context = new AnnotationConfigApplicationContext(jdbcConfig.class);
		StudentDao studentDao = context.getBean("studentDaoImpl", StudentDao.class);
		System.out.println("Choose from the below options");
		SpringJdbcApplication.displayChoice();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		boolean flag = true;

		while (flag) {
			choice = reader.readLine();
			switch (choice) {
			case "1":
				System.out.println("\ninsert id of the student: \n");
				id = Integer.parseInt(reader.readLine());
				System.out.println("\ninsert name of the student: \n");
				name = reader.readLine();
				System.out.println("\ninsert city of the student: \n");
				city = reader.readLine();
				student = new Student(id, name, city);
				System.out.println("Number of records inserted " + studentDao.insert(student));
				SpringJdbcApplication.displayChoice();
				break;
			case "2":
				System.out.println("\ninsert id of the student to be updated: \n");
				id = Integer.parseInt(reader.readLine());
				System.out.println("\ninsert name of the student to be updated:: \n");
				name = reader.readLine();
				System.out.println("\ninsert city of the student to be updated:: \n");
				city = reader.readLine();
				student = new Student(id, name, city);
				System.out.println("Number of records updated " + studentDao.updateValues(student));
				SpringJdbcApplication.displayChoice();
				break;
			case "3":
				System.out.println("\ninsert id of the student to be deleted: \n");
				id = Integer.parseInt(reader.readLine());
				System.out.println("Number of records updated " + studentDao.delete(id));
				SpringJdbcApplication.displayChoice();
				break;
			case "4":
				System.out.println("\ninsert id of the student to get details: \n");
				id = Integer.parseInt(reader.readLine());
				Student studentDetails = studentDao.getStudent(id);
				System.out.println("Student details are: \n"+studentDetails.toString());
				SpringJdbcApplication.displayChoice();
				break;
			case "5":
				for(Student students:studentDao.getStudents())
					System.out.println(students.toString());
				SpringJdbcApplication.displayChoice();
				break;
			case "6":
				SpringJdbcApplication.displayChoice();
				break;
			case "0":
				flag = false;
				System.out.println("Bye!");
				break;
			default:
				System.out.println("Incorrect choice");
				System.out.println("Please select from given menu\n");
				SpringJdbcApplication.displayChoice();
				break;
			}
		}
	}

	public static void displayChoice() {
		System.out.println("1- For Insert Operation");
		System.out.println("2- For Update Operation");
		System.out.println("3- For Delete Operation");
		System.out.println("4- For Displaying Student Details For Id");
		System.out.println("5- For Getting All Students");
		System.out.println("6- For Displaying Menu");
		System.out.println("0- For Exit");
		System.out.println("==========================================");
		System.out.println("Please enter your choice in next line \n");
	}


}
