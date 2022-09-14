package com.poc.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.app.entities.Student;
import com.poc.app.entities.Teacher;
import com.poc.app.entities.User;
import com.poc.app.repository.StudentRepository;
import com.poc.app.repository.TeacherRepository;
import com.poc.app.repository.UserRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@PostMapping("/addstudent")
	public Student saveStudent(@RequestBody Student student) {
		User user = student.getUser();
		String email = user.getEmail();
		if(userRepository.existsByEmail(email))
		{
		System.out.println("Email Already exists");
		}else {
			userRepository.save(user);
			return studentRepository.save(student);
		}
		return null;
	}
	
	@PostMapping("/addteacher")
	public Teacher saveTeacher(@RequestBody Teacher teacher) {
		User user = teacher.getUser();
		String email = user.getEmail();
		if(userRepository.existsByEmail(email))
		{
		System.out.println("Email Already exists");
		}else {
		userRepository.save(user);
		return teacherRepository.save(teacher);
		}
		return null;
	}
	
}
