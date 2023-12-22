package com.sanspeen.todoapp.controller;

import com.sanspeen.todoapp.persistence.entity.Task;
import com.sanspeen.todoapp.persistence.entity.TaskStatus;
import com.sanspeen.todoapp.service.DTO.TaskDTO;
import com.sanspeen.todoapp.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping
    public Task createTask(@RequestBody TaskDTO taskDTO) {
        return taskService.createTask(taskDTO);
    }

    @GetMapping
    public ArrayList<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/task-status/{status}")
    public ArrayList<Task> getAllTasks(@PathVariable TaskStatus status) {
        return taskService.getAllTasksByTaskStatus(status);
    }

    @PatchMapping("/mark-as-finished/{id}")
    public ResponseEntity<Void> markAsFinishedTask(@PathVariable Long id){
        taskService.markTaskAsFinished(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
