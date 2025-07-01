package com.example.lmstemplate01.services.taskService;

import com.example.lmstemplate01.model.task.Task;
import com.example.lmstemplate01.repositoryJPA.taskRepository.TaskRepository;
import com.example.lmstemplate01.web.dto.task.TaskDTO;
import com.example.lmstemplate01.web.mappers.TaskMapper;
import com.example.lmstemplate01.web.mappers.UpdateMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService implements TaskServiceInterface {

    private final TaskRepository taskRepository;

    private final TaskMapper taskMapper;

    private final UpdateMapper updateMapper;

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

    @Transactional(readOnly = true)
    @Override
    public TaskDTO getTask(Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(
                () -> new EntityNotFoundException("Task with id " + taskId + " not found"));
        return taskMapper.toDTO(task);
    }

    @Override
    public List<TaskDTO> getAllTasks(Pageable pageable) {
        return List.of();
    }

    @Override
    public void assignTaskToUser(Long taskId, Long accountId) {

    }
}
