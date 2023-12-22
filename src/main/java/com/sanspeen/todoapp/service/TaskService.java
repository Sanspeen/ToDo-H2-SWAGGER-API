package com.sanspeen.todoapp.service;

import com.sanspeen.todoapp.mapper.TaskDTOToTask;
import com.sanspeen.todoapp.persistence.entity.Task;
import com.sanspeen.todoapp.persistence.repository.TaskRepository;
import com.sanspeen.todoapp.service.DTO.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    TaskDTOToTask taskDTOToTask;

    public Task createTask(TaskDTO taskDTO){
        return taskRepository.save(taskDTOToTask.map(taskDTO));
    }
}
