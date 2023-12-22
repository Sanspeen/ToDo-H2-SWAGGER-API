package com.sanspeen.todoapp.controller;

import com.sanspeen.todoapp.persistence.entity.Task;
import com.sanspeen.todoapp.service.DTO.TaskDTO;
import com.sanspeen.todoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping
    public Task createTask(@RequestBody TaskDTO taskDTO){
     return taskService.createTask(taskDTO);
    }
}
