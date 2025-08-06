package com.example.lmstemplate01.services;

import com.example.lmstemplate01.model.task.Status;
import com.example.lmstemplate01.model.task.Task;
import com.example.lmstemplate01.repositoryJPA.taskRepository.TaskRepository;
import com.example.lmstemplate01.services.taskService.TaskService;
import com.example.lmstemplate01.web.dto.task.TaskDTO;
import com.example.lmstemplate01.web.mappers.TaskMapper;
import com.example.lmstemplate01.web.mappers.UpdateMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Mock
    private TaskMapper taskMapper;

    @Mock
    private UpdateMapper updateMapper;

    private Task task;

    private TaskDTO taskDTO;

    @BeforeEach
    void setUp() {
        int i = 00;
        task = new Task("TaskOne", "Description", Status.TODO, LocalDateTime.of(2025, 11, 15, 12, 00, 00));
       // taskDTO = new TaskDTO("TaskOne", "Description", Status.TODO, );
taskDTO = new TaskDTO();
    }
}
