package com.example.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.example.demo.User;
import com.example.demo.UserRepository;
@ComponentScan("com.example.*")
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void updateUser(int id, User User) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(int id) {
		userRepository.deleteById(id);		
	}

	@Override
	public Collection<User> getUsers() {
		List<User> users= userRepository.findAll();
		return users;
	}
	@Override 
	public String findUserNameById(int userId) {
		  String user1 = userRepository.findById(userId).getName();
		  
		  return user1;
	}
	
	@Override
	public void addUser(User user)
	{
		userRepository.save(user);
	}
	
	@Override 
	public User findByID(int userId) {
		 return userRepository.findById(userId);
	}
	
	public final String helloMethod() {
        return "Hello World!";
    }

	public final String testMethod() {
        return "Hello Test World!";
    }

}
