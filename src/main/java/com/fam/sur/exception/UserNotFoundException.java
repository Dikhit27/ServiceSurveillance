package com.fam.sur.exception;

public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException(String msg) {
		super(msg);
	}
}
