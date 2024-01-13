package com.task.taskManager.controller;

import com.task.taskManager.entity.Task;
import com.task.taskManager.entity.User;
import com.task.taskManager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

    @RestController
    @RequestMapping(value = "/users")
    public class UserController {
    @Autowired
    private UserService userService;

    //    find all the elements in the DB
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> obj = userService.findAll();
        return ResponseEntity.ok().body(obj);
    }

    //    find only specified item
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }


}
