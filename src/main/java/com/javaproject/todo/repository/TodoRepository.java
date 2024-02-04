package com.javaproject.todo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.javaproject.todo.models.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    
}
