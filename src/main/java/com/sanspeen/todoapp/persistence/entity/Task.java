package com.sanspeen.todoapp.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private Long id;

    private String title;
    private String description;
    private LocalDateTime createDate;
    private LocalDateTime eta;
    private boolean finished;
    private TaskStatus taskStatus;
}
