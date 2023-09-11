package com.spring.blog.services;

import java.util.List;

import com.spring.blog.payloads.UserDTO;

import jakarta.websocket.server.ServerEndpoint;

public interface UserService {
	
	UserDTO createUser(UserDTO user);
	UserDTO updateUser(UserDTO user, Integer userId);
	UserDTO getUserById(Integer userId);
	List<UserDTO> getAllUsers();
	void deleteUser(Integer userId);
	
}
