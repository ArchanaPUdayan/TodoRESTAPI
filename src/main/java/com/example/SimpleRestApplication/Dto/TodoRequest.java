package com.example.SimpleRestApplication.Dto;

import java.util.Date;

//we are storing todo type of data 
public class TodoRequest {
	
	private String description;
	private String status;
	private Date submissionDate;
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
	public TodoRequest(String description, String status, Date submissionDate) {
		super();
		this.description = description;
		this.status = status;
		this.submissionDate = submissionDate;
	}
	@Override
	public String toString() {
		return "TodoRequest [description=" + description + ", status=" + status + ", submissionDate=" + submissionDate
				+ "]";
	}
	
	

}
