package com.diospyros.uplift.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class RegisterDTO {
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    private MultipartFile avatar;
    private String userType;
}
