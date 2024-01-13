package com.task.taskManager.service;
import com.task.taskManager.dto.TaskDTO;
import com.task.taskManager.entity.Task;
import com.task.taskManager.entity.User;
import com.task.taskManager.repository.TaskRepository;
import com.task.taskManager.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;
@Transactional(readOnly = true)
    public List<TaskDTO> findAll(){
     List<Task>list = repository.findAll();
     return list.stream().map(x -> new TaskDTO(x)).toList();

    }
    @Transactional(readOnly = true)
    public TaskDTO findById(Long id){
    Optional<Task> obj = repository.findById(id);
    Task entity =obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
    return new TaskDTO(entity);
    }
@Transactional
    public TaskDTO insert(TaskDTO dto){
        Task entity = new Task();
        entity.setName(dto.getName());
        entity = repository.save(entity);
        return new TaskDTO(entity);
    }
@Transactional
    public TaskDTO update(Long id , TaskDTO obj){
        try {
               Task entity = repository.getReferenceById(id);
               entity.setName(obj.getName());
               entity.setDescription(obj.getDescription());
               entity = repository.save(entity);
               return new TaskDTO(entity);
        }
        catch (ResourceNotFoundException e){
            throw new ResourceNotFoundException ("id not found "+id);
        }
    }
    public void delete(Long id){
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("empty");
        }
        catch (IllegalArgumentException e){
            throw new ResourceNotFoundException("illegal argument");
        }
    }




}
