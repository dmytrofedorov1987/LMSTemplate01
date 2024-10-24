package com.example.lmstemplate01.services.userService;

import com.example.lmstemplate01.web.dto.user.RoleDTO;
import com.example.lmstemplate01.model.user.Role;
import com.example.lmstemplate01.repositoryJPA.userRepository.RoleRepository;
import com.example.lmstemplate01.model.exceptions.MLSTemplateRuntimeException;
import com.example.lmstemplate01.web.mappers.RoleMapper;
import com.example.lmstemplate01.web.mappers.UpdateMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class RoleService implements RoleServiceInterface {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;
    private final UpdateMapper updateMapper;

    @Transactional
    @Override
    public RoleDTO createRole(RoleDTO roleDTO) {
        if (roleRepository.existsById(roleDTO.getId())) {
            throw new MLSTemplateRuntimeException("Role exists.");
        }
        Role role = modelMapper.map(roleDTO, Role.class);
        roleRepository.save(role);
        return modelMapper.map(role, RoleDTO.class);
    }

    @Transactional
    @Override
    public RoleDTO updateRole(RoleDTO roleDTO, String id) {
        Role role = roleRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Role with id " + id + " not found"));
        role.setLabel(roleDTO.getLabel());
        roleRepository.save(role);
        return modelMapper.map(role, RoleDTO.class);
    }

    @Transactional
    @Override
    public void deleteRole(String id) {
        if (roleRepository.existsById(id)) {
            roleRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Role doesn't exist.");
        }
    }

    @Transactional(readOnly = true)
    @Override
    public RoleDTO getRole(String id) {
        Role role = roleRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Role with id " + id + " not found"));
        return modelMapper.map(role, RoleDTO.class);
    }

    @Transactional(readOnly = true)
    @Override
    public List<RoleDTO> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        if (!roles.isEmpty()) {
            List<RoleDTO> rolesDTO = new ArrayList<>();
            roles.forEach(a -> rolesDTO.add(modelMapper.map(a, RoleDTO.class)));
            return rolesDTO;
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Transactional(readOnly = true)
    @Override
    public long count() {
        return roleRepository.count();
    }

}
