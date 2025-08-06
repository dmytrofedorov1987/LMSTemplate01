package com.example.lmstemplate01.web.mappers;

import com.example.lmstemplate01.model.task.Task;
import com.example.lmstemplate01.web.dto.task.TaskDTO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TaskMapper {

    TaskDTO toDTO(Task task);

    Task toEntity(TaskDTO taskDTO);

    List<TaskDTO> toDTO(List<Task> tasks);

}
