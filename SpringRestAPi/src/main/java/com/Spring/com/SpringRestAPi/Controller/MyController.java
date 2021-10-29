package com.Spring.com.SpringRestAPi.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.com.SpringRestAPi.Services.CourseService;
import com.Spring.com.SpringRestAPi.entities.Course;


@RestController
public class MyController {
	
	@Autowired
	public CourseService courseService;
	
	/**
	 * @author gupta.mansi
	 * This return the home page message for Courses home page
	 * @return String
	 */
	@GetMapping("/home")
	public String getHome()
	{
		return "Hey! Welcome to Courses home page.";
	}
	
	/**
	 * @author gupta.mansi
	 * This method return the list of all the courses
	 * @return List<Courses>
	 */
	@GetMapping("/courses")
	public List<Course> getCourses()
	{
		return this.courseService.getCourses();
		
	}

}
