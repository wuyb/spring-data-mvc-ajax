package com.springapp.mvc.service.impl;

import com.springapp.mvc.domain.Todo;
import com.springapp.mvc.repository.TodoRepository;
import com.springapp.mvc.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;

public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository repository;

    public Iterable<Todo> getTodos() {
        return repository.findAll();
    }

    public Todo getTodo(Long id) {
        return repository.findOne(id);
    }

    public Todo addTodo(Todo todo) {
        return repository.save(todo);
    }

    public void updateTodo(Todo todo) {
        repository.save(todo);
    }

    public void deleteTodo(Todo todo) {
        repository.delete(todo);
    }
}
