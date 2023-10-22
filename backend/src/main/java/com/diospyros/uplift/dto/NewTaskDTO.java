package com.diospyros.uplift.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.UUID;

@Data
public class NewTaskDTO implements Serializable {
    private String title;
    private String description;
    private String taskType;
    private String tag;
    private String latitude;
    private String longtitude;
    private Integer reward;
    private UUID creatorId;
    private MultipartFile[] photos;
}
