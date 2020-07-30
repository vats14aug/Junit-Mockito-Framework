package com.example.service;

import java.util.Collection;

import org.springframework.context.annotation.ComponentScan;

import com.example.demo.User;
@ComponentScan("com.example.*")
public interface UserService {
	   public void updateUser(int id, User User);
	   public void deleteUser(int id);
	   public String  findUserNameById(int id);
	   public User  findByID(int id);
	   public Collection<User> getUsers();
	   public void addUser(User user);
}
