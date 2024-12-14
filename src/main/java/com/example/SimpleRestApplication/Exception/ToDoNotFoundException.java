package com.example.SimpleRestApplication.Exception;

public class ToDoNotFoundException extends RuntimeException{
	
	private String message;

	public String getMessage() {
		return message;
	}

	public ToDoNotFoundException(String message) {
		super();
		this.message = message;
	}

	public ToDoNotFoundException() {
		super();
	}

	
	
	

}
