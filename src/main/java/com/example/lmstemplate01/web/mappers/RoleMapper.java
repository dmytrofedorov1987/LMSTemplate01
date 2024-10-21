package com.example.lmstemplate01.web.mappers;

import com.example.lmstemplate01.model.user.Role;
import com.example.lmstemplate01.web.dto.user.RoleDTO;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * MapStruct Framework for Model<->DTO and DTO<->Model
 */
@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role toEntity(RoleDTO roleDTO);

    RoleDTO toDto(Role role);

    List<RoleDTO> toDto(List<Role> roles);

}
