package com.javaproject.todo.service;

import org.springframework.stereotype.Service;

import com.javaproject.todo.models.Todo;
import com.javaproject.todo.repository.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
    
    public void delete(int id) {
      Todo todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo could not be found"));
      if (todo != null) {
        todoRepository.delete(todo);
      }
    }

    public void save(Todo todo) {
      if (todo != null && todo.getId() != null){     
        if (todoRepository.existsById(todo.getId())) {
          todoRepository.save(todo);
        } else {
          todoRepository.save(todo);
        }
      }
    }

    public List<Todo> findAll() {
      return todoRepository.findAll();
    }

    public Todo findById(int id) {
      Todo todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo could not be found"));
      return todo;
    }

    public void update(Todo todo) {
      if (todo != null && todo.getId() != null){     
        if (todoRepository.existsById(todo.getId())) {
          todoRepository.save(todo);
        } else {
          throw new RuntimeException("Todo could not be found");
        }
      }
    }

}
