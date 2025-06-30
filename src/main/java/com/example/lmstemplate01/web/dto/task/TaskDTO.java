package com.example.lmstemplate01.web.dto.task;

import com.example.lmstemplate01.model.task.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TaskDTO {//TODO
    private Long id;
    private String title;
    private String description;
    private Status status;
    private LocalDateTime expirationDate;

}
