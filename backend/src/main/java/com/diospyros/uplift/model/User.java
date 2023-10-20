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
public class User {
    @Id
    Long id;
    String username;
    String email;
    Long avatarId;
    Long balance;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    Date createdAt;
}
