package com.example.lmstemplate01.repositoryJPA.taskRepository;

import com.example.lmstemplate01.model.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findAllTasksByUserId(Long accountId);

    void assignTaskToUserById(Long taskId, Long accountId);


}
