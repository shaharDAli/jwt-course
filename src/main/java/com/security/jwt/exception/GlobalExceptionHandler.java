package com.security.jwt.exception;

import java.time.ZonedDateTime;
import java.util.Collections;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.security.jwt.exception.JWTExceptions.FieldsMissingException;
import com.security.jwt.response.ApiResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
   
	@ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiException> handleBadRequestException(BadRequestException ex, WebRequest request) {
        ApiException apiException = new ApiException(
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                ex.getMessage(),
                ex,
                ZonedDateTime.now(),
                Collections.emptyList()
        );
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(value = NullPointerException.class)
	public ResponseEntity<Object> handleNullPointerException(NullPointerException ex, WebRequest request){
		ApiException apiException = new ApiException
				(
					HttpStatus.INTERNAL_SERVER_ERROR.value(),
					HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
					ex.getMessage(),
					ex,
					ZonedDateTime.now(),
					Collections.emptyList());
		return new ResponseEntity<>(apiException, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = RequestIsNullException.class)
	public ResponseEntity<Object> handleRequestIsNullException(RequestIsNullException ex){
		ApiException exception = new ApiException
				(
						HttpStatus.BAD_REQUEST.value(),
						HttpStatus.BAD_REQUEST.getReasonPhrase(),
						ex.getMessage(),
						ex,
						ZonedDateTime.now(),
						Collections.emptyList());
		return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = FieldsMissingException.class)
	public ResponseEntity<Object> handleFieldsMissingException(FieldsMissingException ex){
		ApiException exception = new ApiException
				(
						HttpStatus.BAD_REQUEST.value(),
						HttpStatus.BAD_REQUEST.getReasonPhrase(),
						ex.getMessage(),
						ex,
						ZonedDateTime.now(),
						Collections.emptyList());
		return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
	}
}
