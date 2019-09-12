package com.leavemanagement.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter


public class LoginException extends RuntimeException{
	

	private static final long serialVersionUID = 1L;
	private final String message;
	public LoginException(String message) {
		this.message = message;
	}
	
	
}
