package com.example.SimpleRestApplication.entity;



import java.util.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Component
public class Todo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String description;
	private String status;
	private Date submissionDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getSubmissionDate() {
		return submissionDate;
	}
	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}
	public Todo(int id, String description, String status, Date submissionDate) {
		super();
		this.id = id;
		this.description = description;
		this.status = status;
		this.submissionDate = submissionDate;
	}
	public Todo() {
		super();
	}
	
	

}
