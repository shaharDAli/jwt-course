package com.security.jwt.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties
public class UserDto {

	private Long id;
	private String username;
	private String password;
	private String email;
	private String mobileNo;
	private Boolean isActive;
	private String createdAt;
	private String updatedAt;
	private Long loginCount;
}
