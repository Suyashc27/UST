package com.poc.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.app.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer>{

}
