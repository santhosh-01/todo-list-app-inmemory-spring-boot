package com.todolist.app.repositeries;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todolist.app.model.TodoTask;

public interface TodoListRepositeries extends JpaRepository<TodoTask, Long>{

	List<TodoTask> findAllByTodoTitle(String title);
	
}
