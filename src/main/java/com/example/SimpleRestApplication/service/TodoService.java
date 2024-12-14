package com.example.SimpleRestApplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.SimpleRestApplication.Dto.TodoRequest;
import com.example.SimpleRestApplication.Dto.TodoResponse;
import com.example.SimpleRestApplication.Exception.ToDoNotFoundException;
import com.example.SimpleRestApplication.entity.Todo;
import com.example.SimpleRestApplication.repository.TodoRepository;
import com.example.SimpleRestApplication.utils.ResponseStructure;

@Service
public class TodoService {
	
	@Autowired
	TodoRepository repo;
	
	@Autowired
	ResponseStructure<TodoResponse> resp;

	public ResponseEntity<ResponseStructure<TodoResponse>> save(Todo todo) {
		// TODO Auto-generated method stub
		Todo save=repo.save(todo);
		TodoResponse tr=new TodoResponse();
		tr.setDescription(save.getDescription());
		tr.setStatus(save.getStatus());
		
		resp.setStatus(HttpStatus.OK.value());
		resp.setMessage("inserted successfully....");
		resp.setData(tr);
		return new ResponseEntity<ResponseStructure<TodoResponse>>(resp,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<TodoResponse>> getTodoBasedOnId(int id) {
		
		if(repo.findById(id).isEmpty()) {
			throw new ToDoNotFoundException("No ToDo available for the specified id");
			
		}
		Optional<Todo> todo=repo.findById(id);
		Todo todo2=todo.get();
		TodoResponse tres=new TodoResponse();
		tres.setDescription(todo2.getDescription());
		tres.setStatus(todo2.getStatus());
		resp.setStatus(HttpStatus.OK.value());
		resp.setMessage("successfully fetched...");
		resp.setData(tres);
		return new ResponseEntity<ResponseStructure<TodoResponse>>(resp,HttpStatus.OK);
		// TODO Auto-generated method stub
		
	}

	public ResponseEntity<ResponseStructure<TodoResponse>> updateTodo(int id, TodoRequest req) {
		
		if(repo.findById(id).isEmpty()) {
			throw new ToDoNotFoundException("No ToDo available for the specified id");
		}
		Optional<Todo> todo=repo.findById(id);
		Todo todo3=todo.get();
		todo3.setDescription(req.getDescription());
		todo3.setStatus(req.getStatus());
		todo3.setSubmissionDate(req.getSubmissionDate());
		
		Todo updatedTodo=repo.save(todo3);
		TodoResponse tree=new TodoResponse();
		tree.setDescription(updatedTodo.getDescription());
		tree.setStatus(updatedTodo.getStatus());
		resp.setStatus(HttpStatus.OK.value());
		resp.setMessage("Successfully Updated");
		resp.setData(tree);
		
		// TODO Auto-generated method stub
		return new ResponseEntity<ResponseStructure<TodoResponse>>(resp,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<TodoResponse>> deleteTodoById(int id) {
		if(repo.findById(id).isEmpty()) {
			throw new ToDoNotFoundException("No ToDo available for the specified id");
		}
		Optional<Todo> todo=repo.findById(id);
		Todo todo4=todo.get();
		repo.deleteById(id);
		TodoResponse trees=new TodoResponse();
		trees.setDescription(todo4.getDescription());
		trees.setStatus(todo4.getStatus());
		resp.setStatus(HttpStatus.OK.value());
		resp.setMessage("deleted successfully...");
		resp.setData(trees);
		
		
		// TODO Auto-generated method stub
		return new ResponseEntity<ResponseStructure<TodoResponse>>(resp,HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<List<TodoResponse>>> saveAllTodo(List<TodoRequest> req) {
	    // TODO Auto-generated method stub
	    List<Todo> responses = new ArrayList<>();
	    for (TodoRequest req1 : req) {
	        Todo todo5 = new Todo();
	        todo5.setDescription(req1.getDescription());
	        todo5.setStatus(req1.getStatus());
	        todo5.setSubmissionDate(req1.getSubmissionDate());
	        responses.add(todo5);
	    }

	    List<Todo> savedTodos = repo.saveAll(responses);
	    List<TodoResponse> response = new ArrayList<>();

	    for (Todo save : savedTodos) {
	        TodoResponse todoResponse = new TodoResponse();
	        todoResponse.setDescription(save.getDescription());
	        todoResponse.setStatus(save.getStatus());
	        response.add(todoResponse);
	    }

	    ResponseStructure<List<TodoResponse>> res = new ResponseStructure<>();
	    res.setStatus(HttpStatus.OK.value());
	    res.setMessage("Todos inserted successfully...");
	    res.setData(response);
	    return new ResponseEntity<>(res, HttpStatus.OK);
	}

}
