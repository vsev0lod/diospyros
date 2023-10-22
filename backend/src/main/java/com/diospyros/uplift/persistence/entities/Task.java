/*
 * Created on 2023-10-21 ( 17:17:38 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 4.1.0
 */
package com.diospyros.uplift.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * JPA entity class for "Task"
 *
 * @author Telosys
 */

@Entity
@Data
@Builder
@Table(name = "task", schema = "public")
public class Task implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    //--- PRIMARY KEY 
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    //--- OTHER DATA FIELDS 
    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "task_type", length = 2147483647)
    private String taskType;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @Column(name = "reward", nullable = false)
    private BigDecimal reward;

    @Column(name = "tag", nullable = false, length = 2147483647)
    private String tag;

    @Column(name = "location")
    private String location;

    @Column(name = "creator_id")
    private UUID creatorId;

    @Column(name = "status")
    private String status;
}
