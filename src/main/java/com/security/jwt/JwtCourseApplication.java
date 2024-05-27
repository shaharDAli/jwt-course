package com.security.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.security.jwt.controller.LoginController;

@SpringBootApplication
public class JwtCourseApplication {
	
	private static final Logger loginfo = LoggerFactory.getLogger(JwtCourseApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JwtCourseApplication.class, args);
	}

}
