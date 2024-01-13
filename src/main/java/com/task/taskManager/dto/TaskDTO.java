package com.task.taskManager.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.task.taskManager.entity.Task;
import com.task.taskManager.entity.User;
import com.task.taskManager.enums.TaskStatus;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

public class TaskDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String description;
    private Instant createAt;
    private TaskStatus status;
    private User client;

public TaskDTO(Task entity){
    this.id = entity.getId();
    this.name = entity.getName();
    this.description = entity.getDescription();
    this.createAt= entity.getCreateAt();
    this.status = entity.getStatus();
    this.client= entity.getClient();
}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Instant createAt) {
        this.createAt = createAt;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }
}
