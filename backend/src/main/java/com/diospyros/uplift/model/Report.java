package com.diospyros.uplift.model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class Report {
    // Java model to store Reports
    // it should contain Photo, comment and executor data
    // id - id of the report
    // Photo - photo of the completed task
    // Executor - user who completed the task
    // Comment - comment of the completed task

    Long id;
    String photo;
    User executor;
    String comment;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    Date createdAt;

}
