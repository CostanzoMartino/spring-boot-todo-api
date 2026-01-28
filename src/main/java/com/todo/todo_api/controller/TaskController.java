package com.todo.todo_api.controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todo.todo_api.Task;
import com.todo.todo_api.TaskRepository;

@RestController
public class TaskController {

	public final TaskRepository taskRepository;
	
	TaskController(TaskRepository repository){
		taskRepository = repository;	
	}
	
	@GetMapping("/tasks")
	Iterable<Task> getTasks(){
		return taskRepository.findAll();
	}
	
	@GetMapping("/tasks/{id}")
	Task getTasks(@PathVariable Long id){
		return taskRepository.findById(id).orElseThrow();
	}
	
	@PostMapping("/tasks")
	Task createTask(@RequestBody Task newTask) {
		
		return taskRepository.save(newTask);
	}
	
	@DeleteMapping("/tasks/{id}")
	void deleteTask(@PathVariable Long id) {
		
		Task taskDeleted = taskRepository.findById(id).orElseThrow();
		taskRepository.delete(taskDeleted);
	}
	
	@PutMapping("/tasks/{id}")
	Task updateTask(@PathVariable Long id, @RequestBody Task Dto) {
		Task taskToUpdate = taskRepository.findById(id).orElseThrow();
		taskToUpdate.setTitle(Dto.getTitle());
		taskToUpdate.setDescription(Dto.getDescription());
		taskRepository.save(taskToUpdate);
		return taskToUpdate;
	}
}

