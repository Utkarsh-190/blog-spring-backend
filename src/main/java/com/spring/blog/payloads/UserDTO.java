package com.spring.blog.payloads;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
	
	private int id;

	@NotEmpty
	@Size(min = 4, message = "Username must be minimum of 4 characters")
	private String name;

	@Email(message = "Email is not valid")
	private String email;

	@NotEmpty
	@Size(min = 3, max = 10, message = "Password must be min of 3 and max of 10 characters")
	private String password;

	@NotEmpty
	private String about;

}
