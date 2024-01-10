package com.task.taskManager.service;
import com.task.taskManager.entity.Task;
import com.task.taskManager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public List<Task> findAll(){
       return repository.findAll();
    }
    public Task findById( Long id){
    Optional<Task> task = repository.findById(id);
    return task.get();
    }
}
