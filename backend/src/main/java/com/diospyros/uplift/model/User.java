package com.diospyros.uplift.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Value;

@Entity
@Value
@AllArgsConstructor
public class User {
    @Id
    Long id;
    String username;
    String email;
    Long avatarId;
    double balance;
}
