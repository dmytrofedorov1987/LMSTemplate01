package com.example.lmstemplate01.services;

import com.example.lmstemplate01.dto.RoleDTO;

public interface RoleServiceInterface {
    void createRole(RoleDTO roleDTO);

    void updateRole(RoleDTO roleDTO, String id);

    void deleteRole(String id);

    RoleDTO getRole(String id);

    long count();

}
