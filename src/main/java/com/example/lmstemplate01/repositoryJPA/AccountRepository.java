package com.example.lmstemplate01.repositoryJPA;

import com.example.lmstemplate01.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    Account findByUsername(String username);

}
