package com.example.lmstemplate01.services.userService;

import com.example.lmstemplate01.web.dto.user.RoleDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoleServiceInterface {
    RoleDTO createRole(RoleDTO roleDTO);

    RoleDTO updateRole(RoleDTO roleDTO, String id);

    void deleteRole(String id);

    RoleDTO getRole(String id);

    List<RoleDTO> getAllRoles(Pageable pageable);// Need to retrieve PageRequest?

    long count();

}
