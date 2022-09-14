package com.poc.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc.app.entities.Teacher;
import com.poc.app.entities.User;
import com.poc.app.repository.TeacherRepository;
import com.poc.app.repository.UserRepository;

@RestController
public class TeacherController {
	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/teacher/save/{user_id}")
	public Teacher saveTeacher(@RequestBody Teacher teacher, @PathVariable int user_id) {
		User user = userRepository.findById(user_id).get();
		if(user.getRole_type().equals("teacher"))
		{
			teacher.setUser(user);
		}
		return teacherRepository.save(teacher);
	}
}
