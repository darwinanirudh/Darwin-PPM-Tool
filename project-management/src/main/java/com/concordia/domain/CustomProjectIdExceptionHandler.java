package com.concordia.domain;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class CustomProjectIdExceptionHandler {
 
	@ExceptionHandler
	public final ResponseEntity<Object> handleProjectIdException(ProjectIdExeption exp,WebRequest request){
		
		
		ProjectIdExceptionResponse projIdExpResponse = new ProjectIdExceptionResponse(exp.getMessage());
		
		return new ResponseEntity(projIdExpResponse , HttpStatus.BAD_REQUEST);
		
	}
	
}
