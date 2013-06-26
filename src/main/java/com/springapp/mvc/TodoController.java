package com.springapp.mvc;

import com.springapp.mvc.domain.Todo;
import com.springapp.mvc.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService service;

    @RequestMapping(value="/", method = RequestMethod.GET, headers = {"Accept=application/json"})
    public @ResponseBody
    Iterable<Todo> index() {
        return service.getTodos();
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    Todo create(Todo todo) {
        return service.addTodo(todo);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.PUT, headers = {"Accept=application/json"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable long id, @RequestBody Todo todo) {
        service.updateTodo(todo);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public @ResponseBody
    void delete(@PathVariable long id) {
        Todo todo = service.getTodo(id);
        service.deleteTodo(todo);
    }

}
