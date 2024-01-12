package com.example.lmstemplate01.repositoryJPA;

import com.example.lmstemplate01.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
    boolean existsById(String id);
}
