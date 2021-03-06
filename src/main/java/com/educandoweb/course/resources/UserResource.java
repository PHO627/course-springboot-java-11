package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;
 
@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
 	@GetMapping
	public ResponseEntity<List<User>> FindAll() {		
 		List<User> list = service.findAll(); 
		return ResponseEntity.ok().body(list);
	}
 	
 	@GetMapping(value = "/Id")
 	public ResponseEntity<User> findById(@PathVariable Long Id) {
 		User obj = service.findById(Id);
 		return ResponseEntity.ok().body(obj);
 	}
}