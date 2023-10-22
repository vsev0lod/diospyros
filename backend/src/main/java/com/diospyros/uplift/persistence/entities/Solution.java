/*
 * Created on 2023-10-21 ( 17:17:38 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 4.1.0
 */
package com.diospyros.uplift.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

/**
 * JPA entity class for "Solution"
 *
 * @author Telosys
 */
@Entity
@Data
@Table(name = "solution", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
public class Solution implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    //--- PRIMARY KEY 
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    //--- OTHER DATA FIELDS 
    @Column(name = "description", nullable = false, length = 100)
    private String description;

    @Column(name = "creator_id")
    private UUID creatorId;

    @Column(name = "task_id")
    private UUID taskId;
}
