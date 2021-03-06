package com.spring.SpringJdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.spring.SpringJdbc.entities.Student;

@Component("studentDaoImpl")
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insert(Student student) {
		String query = "insert into student(id,name,city) values(?,?,?)";
		try {
			return jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		} catch (Exception e) {
			System.out.println("Invalid Operation/Id already exists");
			return -1;
		}
	}

	@Override
	public int updateValues(Student student) {
		String query = "update student set city=?, name=? where id=?";
		try {
			return jdbcTemplate.update(query, student.getCity(), student.getName(), student.getId());
		} catch (Exception e) {
			System.out.println("Invalid Operation/Id does not exists");
			return -1;
		}
	}

	@Override
	public int delete(int studentId) {
		String query = "delete from student where id=?";
		try {
			return jdbcTemplate.update(query, studentId);
		} catch (Exception e) {
			System.out.println("Invalid Operation/Id does not exists");
			return -1;
		}

	}
	
	
	@Override
	public Student getStudent(int studentId) {
		String query = "select * from student where id=?";
		return jdbcTemplate.queryForObject(query, new RowMapperImpl(),studentId);
	}
	
	@Override
	public List<Student> getStudents() {
		String query = "Select * from student";
		return jdbcTemplate.query(query, new RowMapperImpl());
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	



}
