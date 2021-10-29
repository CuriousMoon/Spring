package com.Spring.com.SpringRestAPi.Services;

import java.util.List;

import com.Spring.com.SpringRestAPi.entities.Course;

public interface CourseService {
	
	public List<Course> getCourses();
	public Course getCourse(long courseId);
	public String addCourse(Course newCourse);
	public String updateCourse(Course updateCourse);
	public String deleteCourse(long courseId);
}
