package com.example.lmstemplate01.services.userService;

import com.example.lmstemplate01.model.exceptions.MLSTemplateRuntimeException;
import com.example.lmstemplate01.model.user.Role;
import com.example.lmstemplate01.repositoryJPA.userRepository.RoleRepository;
import com.example.lmstemplate01.web.dto.user.RoleDTO;
import com.example.lmstemplate01.web.mappers.RoleMapper;
import com.example.lmstemplate01.web.mappers.UpdateMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
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
        Role role = roleMapper.toEntity(roleDTO);
        Role roleSaved = roleRepository.save(role);
        return roleMapper.toDto(roleSaved);
    }

    @Transactional
    @Override
    public RoleDTO updateRole(RoleDTO roleDTO, String id) {
        Role role = roleRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Role with id " + id + " not found"));
        updateMapper.updateRole(roleDTO, role);
        Role roleUpdated = roleRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Role with id " + id + " after update not found"));
        return roleMapper.toDto(roleUpdated);
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
        return roleMapper.toDto(role);
    }

    /**
     * @return
     */
    @Transactional(readOnly = true)
    @Override
    public List<RoleDTO> getAllRoles(Pageable pageable) {
        List<Role> roles = (List<Role>) roleRepository.findAll(pageable);
        if (!roles.isEmpty()) {
            return roleMapper.toDto(roles);
        } else {
            throw new EntityNotFoundException("List of roles is empty.");
        }
    }

    @Transactional(readOnly = true)
    @Override
    public long count() {
        return roleRepository.count();
    }

    public int totalPages(int size) {
        long totalRoles = roleRepository.count();
        return (int) (totalRoles / size) + (totalRoles % size == 0 ? 0 : 1);
    }

}
