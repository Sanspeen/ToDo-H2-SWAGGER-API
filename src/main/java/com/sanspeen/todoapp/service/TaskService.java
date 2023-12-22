package com.sanspeen.todoapp.service;

import com.sanspeen.todoapp.exceptions.ToDoExceptions;
import com.sanspeen.todoapp.mapper.TaskDTOToTask;
import com.sanspeen.todoapp.persistence.entity.Task;
import com.sanspeen.todoapp.persistence.entity.TaskStatus;
import com.sanspeen.todoapp.persistence.repository.TaskRepository;
import com.sanspeen.todoapp.service.DTO.TaskDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Optional;

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
        Optional<Task> task = taskRepository.findById(id);
        if (task.isEmpty()){
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }

        taskRepository.markTaskAsFinished(id);
    }
}
