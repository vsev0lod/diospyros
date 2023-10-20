package com.diospyros.uplift.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Value;

@Entity
@Value
@AllArgsConstructor
public class Task {
    // Java model to store Tasks
    // it should contain task id, author id, photo, description, location, reward, status(enum), executor id, report id, created at
    // id - id of the task
    //  authorId - id of the author
    //  photo - photo of the task
    //  description - description of the task
    //  location - location of the task
    //  reward - reward of the task
    //  status - status of the task - enum (created, in progress, completed)
    //  executorId - id of the executor
    //  reportId - id of the report
    //  createdAt - date of creation of the task

    Long id;
    int authorId;
    String photo;
    String description;
    String location;
    int reward;
    String status;
    int executorId;
    int reportId;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    Date createdAt;
}
