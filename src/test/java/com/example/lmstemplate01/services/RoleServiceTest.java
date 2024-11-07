package com.example.lmstemplate01.services;


import com.example.lmstemplate01.model.exceptions.MLSTemplateRuntimeException;
import com.example.lmstemplate01.model.user.Role;
import com.example.lmstemplate01.repositoryJPA.userRepository.RoleRepository;
import com.example.lmstemplate01.services.userService.RoleService;
import com.example.lmstemplate01.web.dto.user.RoleDTO;
import com.example.lmstemplate01.web.mappers.RoleMapper;
import com.example.lmstemplate01.web.mappers.UpdateMapper;
import jakarta.persistence.EntityNotFoundException;
import org.glassfish.jaxb.core.v2.TODO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RoleServiceTest {

    @Mock
    private RoleRepository roleRepository;
    @Mock
    private RoleMapper roleMapper;
    @Mock
    private UpdateMapper updateMapper;
    @InjectMocks
    private RoleService roleService;

    private Role role;

    private RoleDTO roleDTO;

    @BeforeEach
    void setUpRoleDTO() {
        role = new Role("admin", "ADMIN");
        roleDTO = new RoleDTO("admin", "ADMIN");
    }

    /**
     * Check create method.
     */
    @Test
    void roleExistAfterCreateRole_returnRoleDTO() {
        RoleDTO expectedRoleDTO = new RoleDTO("admin", "ADMIN");
        when(roleService.createRole(roleDTO)).thenReturn(expectedRoleDTO);
        RoleDTO createdRoleDTO = roleService.createRole(roleDTO);
        assertEquals(expectedRoleDTO, createdRoleDTO);
    }

    /**
     * Check create method.
     */
    @Test
    void roleExistBeforeCreateRole_returnException() {
        MLSTemplateRuntimeException exception = assertThrows(MLSTemplateRuntimeException.class,
                () -> {
                    when(roleRepository.existsById(role.getId())).thenReturn(true);
                    roleService.createRole(roleDTO);
                });
        assertEquals("Role exists.", exception.getMessage());
    }

    /**
     * Check update method.
     */
    @Test
    void roleExistAfterUpdateRole_returnUpdatedRoleDTO() {
        RoleDTO newRoleDTO = new RoleDTO("user", "CUSTOMER");
        RoleDTO expectedRoleDTO = new RoleDTO("user", "CUSTOMER");
        Optional<Role> optionalRole = Optional.of(role);

        when(roleRepository.findById("admin")).thenReturn(optionalRole);

        when(roleService.updateRole(newRoleDTO, role.getId())).thenReturn(expectedRoleDTO);
        RoleDTO actualRoleDTO = roleService.updateRole(newRoleDTO, role.getId());
        assertEquals(expectedRoleDTO, actualRoleDTO);
    }
    /**
     * Check update method.
     */
    @Test
    void roleExistBeforeUpdateRole_returnException() {
        //TODO
    }

    /**
     * Check delete method.
     */
    @Test
    void roleIsNullAfterDeleteRole_returnVoid() {
        when(roleRepository.existsById("admin")).thenReturn(true);
        roleService.deleteRole(role.getId());
        verify(roleRepository, times(1)).deleteById(role.getId());
    }

    /**
     * Check delete method.
     */
    @Test
    void roleIsNullBeforeDeleteRole_returnException() {
        EntityNotFoundException exception = assertThrows(
                EntityNotFoundException.class,
                () -> {
                    when(roleRepository.existsById("admin")).thenReturn(false);
                    roleService.deleteRole(role.getId());
                });
        assertEquals("Role doesn't exist.", exception.getMessage());
    }
}
