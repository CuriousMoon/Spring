package com.Spring.com.SpringRestAPi.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Spring.com.SpringRestAPi.entities.Course;
@Service
public class CourseServiceImpl implements CourseService{
	
	List<Course> list;
	
	public CourseServiceImpl()
	{
		list = new ArrayList<Course>();
		list.add(new Course(1,"Java","This course covers core and advance java features"));
		list.add(new Course(2,"Spring","This course covers spring framework and creates a rest api of courses"));
	}

	/**
	 * This method return the list of courses
	 * @return List<Course>
	 */
	@Override
	public List<Course> getCourses() {
		
		return this.list;
	}
	
	/**
	 * This method return the course detail for given course id
	 * @param course id
	 * @return Course
	 */
	public Course getCourse(long courseId)
	{
		Course courseDetails=null;
		for(Course course:list)
			if(course.getId()==courseId)
				courseDetails=course;
		if(courseDetails==null)
			return new Course(-1,"null","Course id does not exsists");
		return courseDetails;	
	}
	
	/**
	 * This method is used to add course to the existing course list
	 * @param Course
	 * @return String
	 */
	@Override
	public String addCourse(Course newCourse) {
		boolean flag=false;
		String exists="";
		for(Course course:list)
			if(course.getId()==newCourse.getId()) {
				flag=true;
				exists = course.toString();
			}
		if(flag)
			return "Course already exsists \n"+exists;
		list.add(newCourse);
		return "Course has been added successfully";
	}
	
	/**
	 * This method updates the course details for given id
	 * @param CourseId
	 * @return String
	 */
	@Override
	public String updateCourse(Course updateCourse) {
		boolean flag=false;
		for(Course course:list)
			if(course.getId()==updateCourse.getId()){
				flag=true;
				course.setTitle(updateCourse.getTitle());
				course.setDescription(updateCourse.getDescription());
			}
		if(!flag)
			return "Incorrect id";
		return "Course has been successfully updated";
	}

	@Override
	public String deleteCourse(long courseId) {
		boolean flag=false;
		for(Course course:list)
			if(course.getId()==courseId){
				flag=true;
				list.remove(list.indexOf(course));
			}
		if(!flag)
			return "Id does not exsists";
		return "Course successfully deleted";
	}

}
