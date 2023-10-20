package com.diospyros.uplift.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Value;

@Entity
@Value
@AllArgsConstructor
public class Avatar {
    // Java model to store Avatars for the users
    // It should contain avatar id, and image
    // id - id of the avatar
    // image - image of the avatar base64 encoded
    @Id
    Long id;
    String image;
}
