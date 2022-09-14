package com.poc.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc.app.entities.Student;
import com.poc.app.entities.User;
import com.poc.app.repository.StudentRepository;
import com.poc.app.repository.UserRepository;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/student/save")
	public Student saveStudent(@RequestBody Student student) {
	//User user = userRepository.findById(user_id).get();
		User user = student.getUser();
		userRepository.save(user);
		return studentRepository.save(student);
	}
}
