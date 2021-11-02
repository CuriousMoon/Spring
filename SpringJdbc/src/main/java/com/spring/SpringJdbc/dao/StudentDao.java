package com.spring.SpringJdbc.dao;

import com.spring.SpringJdbc.entities.Student;

public interface StudentDao {
	public int insert(Student student);
	public int updateValues(Student student);
}
