package com.loginext.cabbooking.Exception;

public class ValidationException extends RuntimeException{

	String message;

	public ValidationException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
