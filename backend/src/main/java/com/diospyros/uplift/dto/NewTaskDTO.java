package com.diospyros.uplift.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class NewTaskDTO implements Serializable {
    private String title;
    private String description;
    private String taskType;
    private String tag;
    private String latitude;
    private String longtitude;
    private Integer reward;
    private Integer creatorId;
    private MultipartFile[] photos;
}
