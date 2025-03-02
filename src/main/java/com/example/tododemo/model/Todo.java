package com.example.tododemo.model;

import jakarta.persistence.*;


@Entity
@Table(name = "todos") 
public class Todo{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private boolean isCompleted;

    public Todo(){}

    public Todo(String title , boolean isCompleted){
        this.title = title;
        this.isCompleted = isCompleted;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    public boolean isCompleted(){
        return isCompleted;
    }
    public void setIsCompleted(boolean isCompleted){
        this.isCompleted = isCompleted;
    }

}