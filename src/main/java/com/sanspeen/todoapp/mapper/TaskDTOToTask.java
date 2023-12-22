package com.sanspeen.todoapp.mapper;

import com.sanspeen.todoapp.persistence.entity.Task;
import com.sanspeen.todoapp.persistence.entity.TaskStatus;
import com.sanspeen.todoapp.service.DTO.TaskDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskDTOToTask implements IMapper<TaskDTO, Task>{

    @Override
    public Task map(TaskDTO in) {
        Task task = new Task();
        task.setTitle(in.getTitle());
        task.setDescription(in.getDescription());
        task.setEta(in.getEta());
        task.setCreateDate(LocalDateTime.now());
        task.setFinished(false);
        task.setTaskStatus(TaskStatus.ON_TIME);
        return null;
    }
}
