package com.example.SimpleRestApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SimpleRestApplication.Dto.TodoRequest;
import com.example.SimpleRestApplication.Dto.TodoResponse;
import com.example.SimpleRestApplication.entity.Todo;
import com.example.SimpleRestApplication.service.TodoService;
import com.example.SimpleRestApplication.utils.ResponseStructure;

@RestController
@RequestMapping("todo")
public class TodoController {

    @Autowired
    TodoService service;

    @Autowired
    Todo todo;

    // Save a todo item
    @PostMapping("/save")
    public ResponseEntity<ResponseStructure<TodoResponse>> save(@RequestBody TodoRequest req) {
        todo.setDescription(req.getDescription());
        todo.setStatus(req.getStatus());
        todo.setSubmissionDate(req.getSubmissionDate());
        

        ResponseEntity<ResponseStructure<TodoResponse>> resp=service.save(todo);
        return resp;
    }

    // Retrieve a todo item based on its ID
    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseStructure<TodoResponse>> getTodo(@PathVariable("id") int id) {
    	 ResponseEntity<ResponseStructure<TodoResponse>> resp=service.getTodoBasedOnId(id);
        return resp;
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseStructure<TodoResponse>> updateTodo(@PathVariable("id") int id,@RequestBody TodoRequest req){
    	ResponseEntity<ResponseStructure<TodoResponse>> resp1=service.updateTodo(id,req);
		return resp1;
    	
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseStructure<TodoResponse>> deleteTodo(@PathVariable("id") int id){
    	ResponseEntity<ResponseStructure<TodoResponse>> resp2=service.deleteTodoById(id);
		return resp2;
    	
    }
    
    @PostMapping("/saveAll")
    public ResponseEntity<ResponseStructure<List<TodoResponse>>> saveAllTodos(@RequestBody List<TodoRequest> req) {
        return service.saveAllTodo(req);
    }

}
