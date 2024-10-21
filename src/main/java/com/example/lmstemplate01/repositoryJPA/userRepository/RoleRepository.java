package com.example.lmstemplate01.repositoryJPA.userRepository;

import com.example.lmstemplate01.model.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
    boolean existsById(String id);
}