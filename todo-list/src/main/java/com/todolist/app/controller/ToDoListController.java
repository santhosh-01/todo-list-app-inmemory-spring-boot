package com.todolist.app.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.todolist.app.model.TodoTask;
import com.todolist.app.repositeries.TodoListRepositeries;

@Controller
@RequestMapping("/")
public class ToDoListController {
	
	@Autowired
	private TodoListRepositeries todoListRepositeries;
	
	@RequestMapping(method = RequestMethod.GET, value = "/todo-list/{title}")
	public String getListByTitle(@PathVariable("title") String header, Model model) {
		
		List<TodoTask> res = todoListRepositeries.findAllByTodoTitle(header);
		model.addAttribute("tasks",res);
		
		return "todo-list";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/todo", consumes = "application/json")
	public ResponseEntity<Object> addTask(@RequestBody TodoTask task) {
		
		todoListRepositeries.save(task);
		return ResponseEntity.ok().build();
	}

}
