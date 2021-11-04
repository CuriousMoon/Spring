package com.Spring.com.SpringRestAPi.Services;

import java.util.List;

import com.Spring.com.SpringRestAPi.entities.Course;

public interface CourseService {
	
	public List<Course> getCourses();
	public Course getCourse(long courseId);
	public Course addCourse(Course newCourse);
	public Course updateCourse(Course updateCourse);
	public void deleteCourse(long courseId);
}
