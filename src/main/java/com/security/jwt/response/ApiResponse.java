package com.security.jwt.response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiResponse {

	public static ResponseEntity<Object> retrieved(Object object) {

		Map<String, Object> response = new HashMap<String, Object>();
		response.put("status", "success");
		response.put("code", HttpStatus.OK);
		response.put("payload", object);
		response.put("message", "created successfully");

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	public static ResponseEntity<Object> created(Object object) {

		Map<String, Object> response = new HashMap<String, Object>();
		response.put("status", "success");
		response.put("code", HttpStatus.CREATED);
		response.put("payload", object);
		response.put("message", "created successfully");

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	public static ResponseEntity<Object> updated(Object object) {

		Map<String, Object> response = new HashMap<String, Object>();
		response.put("status", "success");
		response.put("code", HttpStatus.OK);
		response.put("payload", object);
		response.put("message", "created successfully");

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	public static ResponseEntity<Object> authLogin(Object object) {
		Map<String,Object> response = new HashMap<String, Object>();
		response.put("status", !object.equals("failed")  ? "success" : "failed");
		response.put("code",  !object.equals("failed") ? HttpStatus.ACCEPTED : HttpStatus.NOT_ACCEPTABLE);
		response.put("payload", object);
		response.put("message", "");
		
		return new ResponseEntity<>(response, !object.equals("failed") ? HttpStatus.ACCEPTED : HttpStatus.NOT_ACCEPTABLE);
	}

}