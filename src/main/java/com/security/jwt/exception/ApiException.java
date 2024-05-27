package com.security.jwt.exception;

import java.time.ZonedDateTime;
import java.util.List;

public class ApiException {
	
	private final int code;
	private final String status;
	private final String message;
	private final Throwable error;
	private final ZonedDateTime timestamp;
	private final List<Object> fieldErrors;
	
	public ApiException(int code, String status, String message, Throwable error, ZonedDateTime timestamp,
			List<Object> fieldErrors) {
		super();
		this.code = code;
		this.status = status;
		this.message = message;
		this.error = error;
		this.timestamp = timestamp;
		this.fieldErrors = fieldErrors;
	}
	
	public int getCode() {
		return code;
	}
	public String getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public Throwable getError() {
		return error;
	}
	public ZonedDateTime getTimestamp() {
		return timestamp;
	}
	public List<Object> getFieldErrors() {
		return fieldErrors;
	}
	
	
	
	
}
