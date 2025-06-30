package com.example.lmstemplate01.repositoryJPA.userRepository;

import com.example.lmstemplate01.model.user.Role;
import jdk.jfr.Registered;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

    boolean existsById(String id);

    Page<Role> findAll(Pageable pageable);
}
