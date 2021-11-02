package com.spring.SpringJdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import com.spring.SpringJdbc.dao.StudentDaoImpl;

@Configuration
@ComponentScan(basePackages= {"com.spring.SpringJdbc.dao"})
public class jdbcConfig {
	
	@Bean("ds")
	public DataSource getDataSourceObject()
	{
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate()
	{
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSourceObject());
		return jdbcTemplate;
	}
	
//	@Bean("studentDaoImpl")
//	public StudentDaoImpl getStudentDaoImpl()
//	{
//		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
//		studentDaoImpl.setJdbcTemplate(getJdbcTemplate());
//		return studentDaoImpl;
//	}

}
