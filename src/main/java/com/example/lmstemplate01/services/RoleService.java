package com.example.lmstemplate01.services;

import com.example.lmstemplate01.dto.RoleDTO;
import com.example.lmstemplate01.model.Role;
import com.example.lmstemplate01.repositoryJPA.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class RoleService implements RoleServiceInterface {
    private final RoleRepository roleRepository;

    @Transactional
    @Override
    public void createRole(RoleDTO roleDTO) {
        if (roleRepository.existsById(roleDTO.getId())) {
            return;
        }
        Role role = Role.fromRoleDTO(roleDTO);
        roleRepository.save(role);
    }

    @Transactional
    @Override
    public void updateRole(RoleDTO roleDTO, String id) {
        Role role = getRoleFromOptional(id);
        role.setLabel(roleDTO.getLabel());
        roleRepository.save(role);
    }

    @Transactional
    @Override
    public void deleteRole(String id) {
        roleRepository.deleteById(id);
    }

    @Transactional
    @Override
    public RoleDTO getRole(String id) {
        Role role = getRoleFromOptional(id);
        return role.toRoleDTO();
    }

    @Transactional
    @Override
    public List<RoleDTO> getAllRoles() {// Need to retrieve PageRequest?
        List<Role> roles = roleRepository.findAll();
        List<RoleDTO> rolesDTO = new ArrayList<>();
        roles.forEach(a -> rolesDTO.add(a.toRoleDTO()));
        return rolesDTO;
    }

    @Transactional
    @Override
    public long count() {
        return roleRepository.count();
    }

    /**
     * Method searches and receive a Role by ID.
     *
     * @param id
     * @return Role
     */
    public Role getRoleFromOptional(String id) {
        Role role = new Role();
        var roleOpt = roleRepository.findById(id);
        if (roleOpt.isPresent()) {
            role = roleOpt.get();
        }
        return role;
    }

}
