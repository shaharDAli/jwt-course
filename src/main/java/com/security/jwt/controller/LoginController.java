package com.security.jwt.controller;

import java.time.ZonedDateTime;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.security.jwt.dto.LoginDto;
import com.security.jwt.dto.SignupRequestDto;
import com.security.jwt.dto.UserDto;
import com.security.jwt.exception.ApiException;
import com.security.jwt.response.ApiResponse;
import com.security.jwt.service.UserService;

@RestController
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/signup")
	public ResponseEntity<?> sigunup(@RequestBody SignupRequestDto requestDto) {
		System.out.println(requestDto);
      return ApiResponse.retrieved(userService.signupUser(requestDto));
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginDto requestDto) {
      return ApiResponse.authLogin(userService.AuthLogin(requestDto));
	}

	
	
}
