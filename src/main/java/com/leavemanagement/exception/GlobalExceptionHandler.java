package com.leavemanagement.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> globalExceptionHandler(Exception exception,WebRequest request) {
		  ErrorResponse errorResponse = new ErrorResponse(LocalDate.now(),
		  exception.getMessage(), request.getDescription(false));
		  
		  return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
		  
		  }
	
	
	@ExceptionHandler(LeaveException.class)
	public ResponseEntity<ErrorResponse> globalExceptionHandler(LeaveException exception,
			WebRequest request) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setMessage(exception.getMessage());
		errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorResponse.setTimestamp(LocalDate.now());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
}
