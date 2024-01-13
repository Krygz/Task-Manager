package com.task.taskManager.controller;

import com.task.taskManager.dto.TaskDTO;
import com.task.taskManager.entity.Task;
import com.task.taskManager.entity.User;
import com.task.taskManager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {
    @Autowired
    private TaskService service;

    @GetMapping
    public ResponseEntity<List<TaskDTO>> findAll() {
        List<TaskDTO> dto = service.findAll();
        return ResponseEntity.ok().body(dto);    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TaskDTO> findById(@PathVariable Long id) {
        TaskDTO  tsk = service.findById(id);
        return ResponseEntity.ok().body(tsk);
    }
@PostMapping
    public ResponseEntity<TaskDTO> insert(@RequestBody TaskDTO dto) {
        TaskDTO obj = service.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();
        return ResponseEntity.created(uri).body(obj);
    }
@DeleteMapping(value = "/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
}
@PutMapping(value = "/{id}")
      public ResponseEntity<TaskDTO>update(@PathVariable Long id, @RequestBody TaskDTO obj){
        obj = service.update ( id , obj);
        return ResponseEntity.ok().body(obj);
}
}
