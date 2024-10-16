package com.example.lmstemplate01.services.userService;

import com.example.lmstemplate01.web.dto.user.RoleDTO;

import java.util.List;

public interface RoleServiceInterface {
    RoleDTO createRole(RoleDTO roleDTO);

    RoleDTO updateRole(RoleDTO roleDTO, String id);

    void deleteRole(String id);

    RoleDTO getRole(String id);

    List<RoleDTO> getAllRoles();// Need to retrieve PageRequest?

    long count();

}
