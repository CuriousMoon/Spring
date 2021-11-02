package com.spring.SpringJdbc.dao;

import java.util.List;

import com.spring.SpringJdbc.entities.Student;

public interface StudentDao {
	public int insert(Student student);
	public int updateValues(Student student);
	public int delete(int studentId);
	public Student getStudent(int studentId);
	public List<Student> getStudents();	
}
