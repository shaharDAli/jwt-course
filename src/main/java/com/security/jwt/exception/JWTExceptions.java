package com.security.jwt.exception;

import org.springframework.stereotype.Component;

@Component
public class JWTExceptions {

	 public static class FieldsMissingException extends RuntimeException {
	       
			private static final long serialVersionUID = 5555153883163628671L;

			public FieldsMissingException(String message) {
	            super(message);
	        }
	    }
}
