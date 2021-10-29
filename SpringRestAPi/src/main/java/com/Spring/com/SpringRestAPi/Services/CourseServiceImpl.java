package com.Spring.com.SpringRestAPi.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Spring.com.SpringRestAPi.entities.Course;
@Service
public class CourseServiceImpl implements CourseService{
	
	List<Course> list;

	@Override
	public List<Course> getCourses() {
		list = new ArrayList<Course>();
		list.add(new Course(1,"Java","This course covers core and advance java features"));
		list.add(new Course(2,"Spring","This course covers spring framework and creates a rest api of courses"));
		return list;
	}

}
