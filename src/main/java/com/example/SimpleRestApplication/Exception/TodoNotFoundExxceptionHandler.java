package com.example.SimpleRestApplication.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.SimpleRestApplication.utils.ErrorStructure;

@RestControllerAdvice
public class TodoNotFoundExxceptionHandler {
	
	
	@ExceptionHandler
	public ResponseEntity<ErrorStructure> todoNotFound(ToDoNotFoundException te){
		ErrorStructure err=new ErrorStructure();
		err.setMessage(te.getMessage());
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setRootCause("NO VALUE FOR REQUESTED ID FOUND");
		return new ResponseEntity<ErrorStructure>(err,HttpStatus.NOT_FOUND);
	}

}
