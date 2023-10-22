package com.diospyros.uplift.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
public class LoginDTO implements Serializable {
    private String password;
    private String username;
}
