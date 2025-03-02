package com.example.tododemo.service;

import com.example.tododemo.model.Todo;
import com.example.tododemo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService{
    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }
    public Todo getOneTodo(Long id){
        return todoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Todo not found"+id));
    }
    public Todo createTodo(Todo todo){
        return todoRepository.save(todo);
    }
    public Todo markCompleted(Long id){
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if(optionalTodo.isPresent()){
            Todo todo = optionalTodo.get();
            todo.setIsCompleted(true);
            return todoRepository.save(todo);
        }
        else{
            throw new RuntimeException("TODO NOT FOUND WITH ID "+ id);
        }
    }
    public void deleteTodo(Long id){
        todoRepository.deleteById(id);
    }
}