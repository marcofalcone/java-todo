package com.javaproject.todo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.javaproject.todo.models.Todo;
import com.javaproject.todo.service.TodoService;


public class CrudTest {

  @Autowired
  private TodoService todoService;

  @Test
  public void testCreate() {
    Todo todo = new Todo();
    todo.setTitle("Test Todo");
    todoService.save(todo);
    assertNotNull(todo.getId());
  }

  @Test
  public void testRead() {
    List<Todo> todos = todoService.findAll();
    assertNotNull(todos);
  }

  @Test
  public void testUpdate() {
    Todo todo = new Todo();
    todo.setTitle("Test Todo");
    todoService.save(todo);
    todo.setTitle("Updated Todo");
    todoService.update(todo);
    Todo updatedTodo = todoService.findById(todo.getId());
    assertEquals("Updated Todo", updatedTodo.getTitle());
  }

  @Test
  public void testDelete() {
    Todo todo = new Todo();
    todo.setTitle("Test Todo");
    todoService.save(todo);
    todoService.delete(todo.getId());
    assertNull(todoService.findById(todo.getId()));
  }
}
