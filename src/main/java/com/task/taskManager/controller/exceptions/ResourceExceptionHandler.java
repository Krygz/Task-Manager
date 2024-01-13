package com.task.taskManager.controller.exceptions;

import com.task.taskManager.service.exceptions.DatabaseNotFoundException;
import com.task.taskManager.service.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e , HttpServletRequest request){
    HttpStatus status = HttpStatus.NOT_FOUND;
    StandardError error = new StandardError();
    error.setTimestamp(Instant.now());
    error.setStatus(status.value());
    error.setError("Resource not found");
    error.setMessage(e.getMessage());
    error.setPath(request.getRequestURI());

    return new ResponseEntity<StandardError>(error , HttpStatus.NOT_FOUND);
}
}
