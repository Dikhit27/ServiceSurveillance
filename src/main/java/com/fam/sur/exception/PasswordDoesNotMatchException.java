package com.fam.sur.exception;

public class PasswordDoesNotMatchException extends RuntimeException {

	public PasswordDoesNotMatchException(String msg) {
		super(msg);
	}

}
