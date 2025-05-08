package com.example.lmstemplate01.repositoryJPA.taskRepository;

import com.example.lmstemplate01.model.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllTasksByUserId(Long accountId);

    void assignTaskToUserById(Long taskId, Long accountId);


}
