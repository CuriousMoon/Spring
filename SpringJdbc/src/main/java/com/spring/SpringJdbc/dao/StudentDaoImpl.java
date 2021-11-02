package com.spring.SpringJdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.SpringJdbc.entities.Student;

public class StudentDaoImpl implements StudentDao{

	private JdbcTemplate  jdbcTemplate; 
	
	@Override
	public int insert(Student student) {
		String query = "insert into student(id,name,city) values(?,?,?)";
		return jdbcTemplate.update(query, student.getId(),student.getName(),student.getCity());
	}
	
	@Override
	public int updateValues(Student student) {
		String query = "update student set city=?, name=? where id=?";
		return jdbcTemplate.update(query,student.getCity(),student.getName(),student.getId());
	}
	
	@Override
	public int delete(int studentId) {
		String query = "delete from student where id=?";
		return jdbcTemplate.update(query,studentId);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	



	

}
