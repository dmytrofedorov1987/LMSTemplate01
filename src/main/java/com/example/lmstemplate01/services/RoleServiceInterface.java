package com.example.lmstemplate01.services;

import com.example.lmstemplate01.dto.RoleDTO;
import com.example.lmstemplate01.model.Role;

import java.util.List;

public interface RoleServiceInterface {
    void createRole(RoleDTO roleDTO);

    void updateRole(RoleDTO roleDTO, String id);

    void deleteRole(String id);

    RoleDTO getRole(String id);

    List<RoleDTO> getAllRoles();// Need to retrieve PageRequest?

    long count();

}
