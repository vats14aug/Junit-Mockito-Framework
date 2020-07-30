package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
	//User findByName(String name);
	User findById (int employeeId);
	List<User> findAll();
}