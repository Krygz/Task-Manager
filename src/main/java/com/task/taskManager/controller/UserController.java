package com.task.taskManager.controller;

import com.task.taskManager.entity.User;
import com.task.taskManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;
@GetMapping
    public ResponseEntity<List<User>>findAll(){
        List<User> obj = userService.findAll();
         return ResponseEntity.ok().body(obj);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<User>findById(@PathVariable Long id){
       User user = userService.findById(id);
       return ResponseEntity.ok().body(user);
    }
}
