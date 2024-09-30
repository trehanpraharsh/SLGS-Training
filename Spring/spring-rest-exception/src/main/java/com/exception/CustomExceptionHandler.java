package com.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler(ServletRequestBindingException.class)
	public ResponseEntity<Object> handleHeaderException(Exception ex, WebRequest request){
		List<String> details = new ArrayList<String>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse errorResponse = new ErrorResponse("OOPS....Header missing!", details);
		return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> genericHeaderException(Exception ex, WebRequest request){
		List<String> details = new ArrayList<String>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse errorResponse = new ErrorResponse("Server Side error Caught...!", details);
		return new ResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
