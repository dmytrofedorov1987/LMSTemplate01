package com.example.lmstemplate01.services;

import com.example.lmstemplate01.dto.RoleDTO;
import com.example.lmstemplate01.model.Account;
import com.example.lmstemplate01.model.Role;
import com.example.lmstemplate01.repositoryJPA.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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

    }

    @Transactional
    @Override
    public void deleteRole(String id) {

    }

    @Transactional
    @Override
    public RoleDTO getRole(String id) {

    }

    @Transactional
    @Override
    public long count() {
        return roleRepository.count();
    }

}
