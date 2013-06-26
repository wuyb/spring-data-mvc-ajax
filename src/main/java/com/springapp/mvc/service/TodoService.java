package com.springapp.mvc.service;

import com.springapp.mvc.domain.Todo;

public interface TodoService {
    public Iterable<Todo> getTodos();
    public Todo getTodo(Long id);
    public Todo addTodo(Todo todo);
    public void updateTodo(Todo todo);
    public void deleteTodo(Todo todo);
}
