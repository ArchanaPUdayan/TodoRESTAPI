package com.example.SimpleRestApplication.utils;

import org.springframework.stereotype.Component;

@Component
public class ResponseStructure<T> {
	private int status;
	private String message;
	private T data;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public ResponseStructure(int status, String message, T data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}
	public ResponseStructure() {
		super();
	}
	
	
	
	
}
