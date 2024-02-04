package com.javaproject.todo.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaproject.todo.models.Todo;
import com.javaproject.todo.service.TodoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }
    
    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> getTodos() {
      return new ResponseEntity<>(todoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity<Todo> getTodoById(int id) {
      return ResponseEntity.ok(todoService.findById(id));
    }

    @DeleteMapping("/todo/delete/{id}")
    public ResponseEntity<Void> delete(int id) {
      todoService.delete(id);
      return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/todo/create")
    public ResponseEntity<Todo> create(Todo todo) {
        todoService.save(todo);
        return new ResponseEntity<Todo>(todo, HttpStatus.CREATED);
    }

    @PutMapping("/todo/update/{id}")
    public ResponseEntity<Void> update(Todo todo) {
        todoService.update(todo);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
