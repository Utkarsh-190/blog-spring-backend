package com.spring.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	

}
