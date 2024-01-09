package com.example.lmstemplate01.repositoryJPA;

import com.example.lmstemplate01.model.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomUserRepository extends JpaRepository<CustomUser, Long> {
    boolean existsByEmail(String email);

    CustomUser findByEmail(String email);

}
