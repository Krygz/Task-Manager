package com.task.taskManager.controller;

import com.task.taskManager.entity.Task;
import com.task.taskManager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {
    @Autowired
    private TaskService service;
    @GetMapping
    public ResponseEntity<List<Task>> findAll(){
        List<Task> obj = service.findAll();
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Task>findById(@PathVariable Long id){
        Task tsk = service.findById(id);
        return ResponseEntity.ok().body(tsk);
    }

}
