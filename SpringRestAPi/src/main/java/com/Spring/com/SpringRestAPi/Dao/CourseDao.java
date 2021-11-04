package com.Spring.com.SpringRestAPi.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Spring.com.SpringRestAPi.entities.Course;

public interface CourseDao extends JpaRepository<Course, Long>{

}
