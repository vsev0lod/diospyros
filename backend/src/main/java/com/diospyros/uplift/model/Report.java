package com.diospyros.uplift.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Value
@AllArgsConstructor
public class Report {
    // Java model to store Reports
    // it should contain Photo, comment and executor data
    // id - id of the report
    // Photo - photo of the completed task
    // Executor - user who completed the task
    // Comment - comment of the completed task
    @Id
    Long id;
    String photo;
    User executor;
    String comment;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    Date createdAt;

}
