package com.diospyros.uplift.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class SolutionDTO {

    private String description;

    private MultipartFile[] photos;

}
