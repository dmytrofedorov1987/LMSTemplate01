package com.example.lmstemplate01.services.taskService;

import com.example.lmstemplate01.web.dto.task.TaskDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TaskServiceInterface {

    TaskDTO createTask(TaskDTO taskDTO);

    TaskDTO updateTask(TaskDTO taskDTO, Long taskId);

    void deleteTask(Long taskId);

    TaskDTO getTask(Long taskId);

    List<TaskDTO> getAllTasks(Pageable pageable);

    void assignTaskToUser(Long taskId, Long accountId);
}
