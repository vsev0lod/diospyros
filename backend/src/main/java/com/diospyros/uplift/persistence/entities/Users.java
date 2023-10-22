/*
 * Created on 2023-10-21 ( 17:17:38 )
 * Generated by Telosys ( https://www.telosys.org/ ) version 4.1.0
 */
package com.diospyros.uplift.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * JPA entity class for "Users"
 *
 * @author Telosys
 */

@Entity
@Data
@Table(name = "users", schema = "public")
public class Users implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    //--- PRIMARY KEY 
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    //--- OTHER DATA FIELDS 
    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Column(name = "rating")
    private BigDecimal rating;

    @Column(name = "user_type", nullable = false, length = 2147483647)
    private String userType;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "balance")
    private BigDecimal balance;
}
