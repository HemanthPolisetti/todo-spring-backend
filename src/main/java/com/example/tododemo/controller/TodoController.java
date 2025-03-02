package com.example.tododemo.controller;

import com.example.tododemo.model.Todo;
import com.example.tododemo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class TodoController{

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }
    
    @GetMapping
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getOneTodo(@PathVariable Long id){
        Todo todo = todoService.getOneTodo(id);
        return ResponseEntity.ok(todo);
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo){
        return todoService.createTodo(todo);
    }
    @PutMapping("/{id}/complete")
    public Todo markCompleted(@PathVariable Long id){
        return todoService.markCompleted(id);
    }
    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable Long id){
        todoService.deleteTodo(id);
        return "Todo deleted Successfully";

    }

}