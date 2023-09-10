package com.spring.blog.controllers;

import java.util.List;
import java.util.Map;

import com.spring.blog.payloads.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.blog.payloads.UserDTO;
import com.spring.blog.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDto){
		UserDTO createdUserDTO = this.userService.createUser(userDto);
		return new ResponseEntity<>(createdUserDTO, HttpStatus.CREATED);
	}

	@PutMapping("/{userId}")
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, @PathVariable("userId") Integer uId) {
		UserDTO updatedUserDTO = this.userService.updataUser(userDTO, uId);
		return ResponseEntity.ok(updatedUserDTO);
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer uId){
		this.userService.deleteUser(uId);
//		return new ResponseEntity(Map.of("message", "User Deleted Successfully"), HttpStatus.OK);
		return new ResponseEntity(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<UserDTO>> getAllUsers(){
		return ResponseEntity.ok(this.userService.getAllUsers());
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserDTO> getSingleUser(@PathVariable Integer userId){
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}
}
