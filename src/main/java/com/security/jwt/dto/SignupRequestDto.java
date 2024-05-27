package com.security.jwt.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SignupRequestDto {

	private String username;
	private String password;
	private String email;
	private String mobileNo;
	private Boolean isActive;
}
