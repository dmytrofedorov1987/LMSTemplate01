package com.example.lmstemplate01.web.controllers;

import com.example.lmstemplate01.model.exceptions.MLSTemplateError;
import com.example.lmstemplate01.services.taskService.TaskService;
import com.example.lmstemplate01.web.dto.task.TaskDTO;
import com.example.lmstemplate01.web.dto.user.AccountDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/task")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getTask(@PathVariable(value = "id") Long taskId) {
        try {
            TaskDTO taskDTO = taskService.getTask(taskId);
            return ResponseEntity.ok(taskDTO);
        } catch (EntityNotFoundException exception) {
            return ResponseEntity.ok(
                    new MLSTemplateError(HttpStatus.NOT_FOUND.value(),
                            "Task not found."));
        }

    }




}
