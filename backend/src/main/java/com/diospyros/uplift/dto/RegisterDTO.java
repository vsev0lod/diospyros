package com.diospyros.uplift.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class RegisterDTO {
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    private MultipartFile avatar;
    private String userType;
}
