package com.task.taskManager.config;

import com.task.taskManager.entity.Task;
import com.task.taskManager.entity.User;
import com.task.taskManager.enums.TaskStatus;
import com.task.taskManager.repository.TaskRepository;
import com.task.taskManager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

@Autowired
private TaskRepository taskRepository;
@Autowired
private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {


        User u1 = new User(null , "Maria", "maria@gmail.com");
        User u2 = new User(null , "polo", "poloisz@gmail.com");
        User u3  = new User(null , "yara", "yetszx@gmail.com");



        Task t1 = new Task(null , "almoço","receita do almoço", Instant.now(), TaskStatus.IN_PROGRESS,u1);
        Task t2 = new Task(null , "teclado","pre-set do tecladp", Instant.now(), TaskStatus.COMPLETED ,u2);
        Task t3 = new Task(null , "Gym","Training every day for the carnival", Instant.now(), TaskStatus.LATE, u1);
        Task t4 = new Task(null , "edit","edit for the dream", Instant.now(), TaskStatus.IN_PROGRESS, u3);

        taskRepository.saveAll(Arrays.asList(t1,t2,t3,t4));
        userRepository.saveAll(Arrays.asList(u1,u2,u3));




    }
}
