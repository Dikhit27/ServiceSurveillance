package com.fam.sur.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NoTicketFoundException.class)
	public ResponseEntity<String> handlerNoTicketFoundException(Exception e){
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);	
	}
	
	@ExceptionHandler(PasswordDoesNotMatchException.class)
	public ResponseEntity<String> handlerPasswordDoesNotMatchException(Exception e){
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);	
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handlerUserNotFoundException(Exception e){
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);	
	}
	
	@ExceptionHandler(VehicleNotFoundException.class)
	public ResponseEntity<String> handlerVehicleNotFoundException(Exception e){
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);	
	}
}
