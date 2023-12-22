package com.sanspeen.todoapp.service;

import com.sanspeen.todoapp.mapper.TaskDTOToTask;
import com.sanspeen.todoapp.persistence.entity.Task;
import com.sanspeen.todoapp.persistence.entity.TaskStatus;
import com.sanspeen.todoapp.persistence.repository.TaskRepository;
import com.sanspeen.todoapp.service.DTO.TaskDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TaskService {
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    TaskDTOToTask taskDTOToTask;

    public Task createTask(TaskDTO taskDTO){
        return taskRepository.save(taskDTOToTask.map(taskDTO));
    }

    public ArrayList<Task> getAllTasks(){
        return (ArrayList<Task>) taskRepository.findAll();
    }

    public ArrayList<Task> getAllTasksByTaskStatus(TaskStatus taskStatus){
        return taskRepository.findAllByTaskStatus(taskStatus);
    }

    @Transactional
    public void markTaskAsFinished(Long id){
        taskRepository.markTaskAsFinished(id);
    }
}
