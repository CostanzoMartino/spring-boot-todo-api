package com.todo.todo_api;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity //mappa la classe come entità del db
public class Task {
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id; 
	
	private String title;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private String description;
	
	Task(){}
	
	Task(String title, String description){
		
		this.title = title;
		this.description = description;
	}

}
