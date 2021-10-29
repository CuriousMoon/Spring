package com.Spring.com.SpringRestAPi.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.com.SpringRestAPi.Services.CourseService;
import com.Spring.com.SpringRestAPi.entities.Course;


@RestController
public class MyController {
	
	@Autowired
	public CourseService courseService;
	
	/**
	 * @author gupta.mansi
	 * This end point return the home page message for Courses home page
	 * @return String
	 */
	@GetMapping("/home")
	public String getHome()
	{
		return "Hey! Welcome to Courses home page.";
	}
	
	/**
	 * @author gupta.mansi
	 * This end point return the list of all the courses
	 * @return List<Courses>
	 */
	@GetMapping("/courses")
	public List<Course> getCourses()
	{
		return this.courseService.getCourses();
		
	}
	
	/**
	 * @author gupta.mansi
	 * This end point return the course details for given course id.
	 * @param courseId
	 * @return Course
	 */
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId)
	{
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	/**
	 * @author gupta.mansi
	 * This end point is used to add course
	 * @param newCourse
	 * @return String 
	 */
	@PostMapping("/courses")
	public String addCourse(@RequestBody Course newCourse)
	{
		return this.courseService.addCourse(newCourse);
	}
	
	/**
	 * @author gupta.mansi
	 * This end point is used to update the course for already existing course id
	 * @param course
	 * @return String
	 */
	@PutMapping("/courses")
	public String updateCourse(@RequestBody Course course)
	{
		return this.courseService.updateCourse(course);
	}
	
	/**
	 * @author gupta.mansi
	 * This end point deletes the given course id from course list and return success message
	 * @param courseId
	 * @return String
	 */
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId)
	{
		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		catch(NumberFormatException e)
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
			
		 
	}

}
