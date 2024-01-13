package com.task.taskManager.service.exceptions;

import java.io.Serial;

public class DatabaseNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public DatabaseNotFoundException (String msg) {
        super(msg);
    }
}
