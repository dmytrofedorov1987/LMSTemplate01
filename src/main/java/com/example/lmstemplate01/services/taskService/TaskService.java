package com.example.lmstemplate01.services.taskService;

import com.example.lmstemplate01.web.dto.task.TaskDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements TaskServiceInterface { //TODO

    @Override
    public TaskDTO createTask(TaskDTO taskDTO) {
        return null;
    }

    @Override
    public TaskDTO updateTask(TaskDTO taskDTO, Long taskId) {
        return null;
    }

    @Override
    public void deleteTask(Long taskId) {

    }

    @Override
    public TaskDTO getTask(Long taskId) {
        return null;
    }

    @Override
    public List<TaskDTO> getAllTasks(Pageable pageable) {
        return List.of();
    }

    @Override
    public void assignTaskToUser(Long taskId, Long accountId) {

    }
}
