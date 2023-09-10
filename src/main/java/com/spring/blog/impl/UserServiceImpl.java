package com.spring.blog.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.blog.entities.User;
import com.spring.blog.payloads.UserDTO;
import com.spring.blog.repositories.UserRepo;
import com.spring.blog.services.UserService;
import com.spring.blog.exceptions.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		User user = this.dtoToUser(userDTO);
		User savedUser = this.userRepo.save(user);
		return this.userTodto(savedUser);
	}

	@Override
	public UserDTO updataUser(UserDTO userDTO, Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " id ", userId));
		user.setName(userDTO.getName());
		user.setAbout(userDTO.getAbout());
		user.setPassword(userDTO.getPassword());
		user.setEmail(userDTO.getEmail());
		
		User updatedUser = this.userRepo.save(user);
		return this.userTodto(updatedUser);
	}

	@Override
	public UserDTO getUserById(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId));
		return this.userTodto(user);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> users = this.userRepo.findAll();
		List<UserDTO> userDTOs = users.stream().map(user -> this.userTodto(user)).collect(Collectors.toList());
		return userDTOs;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " id ", userId));
		this.userRepo.delete(user);
	}

	public User dtoToUser(UserDTO userDTO) {
		User user = new User();
		user.setId(userDTO.getId());
		user.setName(userDTO.getName());
		user.setAbout(userDTO.getAbout());
		user.setPassword(userDTO.getPassword());
		user.setEmail(userDTO.getEmail());
		return user;
	}
	
	public UserDTO userTodto(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setName(user.getName());
		userDTO.setAbout(user.getAbout());
		userDTO.setPassword(user.getPassword());
		userDTO.setEmail(user.getEmail());
		return userDTO;
	}
}
