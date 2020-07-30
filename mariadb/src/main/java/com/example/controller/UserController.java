package com.example.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.User;
import com.example.service.UserService;

@RestController

@ComponentScan("com.example.*")
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping("/users")
	public Collection<User> getAllUsers() {
		return userService.getUsers();
	}

	@GetMapping("/user/{id}")
	public String getUserNameByID(@PathVariable(value = "id") int userId) {
		if (!StringUtils.isEmpty(userService.findUserNameById(userId)))
			return (userService.findUserNameById(userId));
		else
			return "User ID is invalid or Username is null..";
	}
	  
	@PostMapping("/addUser")
	/*
	 *   {
        "id": 6,
        "name": "Bob",
        "age": 38
    	}
	 */
	public void createUser(@RequestBody User user) {
	         userService.addUser(user);
	    }

	@DeleteMapping("/deleteUser/{id}")  
	private void deleteBook(@PathVariable("id") int id)   
	{  
	userService.deleteUser(id);  
	}  
}