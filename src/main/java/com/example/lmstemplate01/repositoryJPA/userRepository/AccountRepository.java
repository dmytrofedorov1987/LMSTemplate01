package com.example.lmstemplate01.repositoryJPA.userRepository;

import com.example.lmstemplate01.model.user.Account;
import com.example.lmstemplate01.model.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    boolean existsByEmail(String email);

    boolean existsByUsername(String accountName);

    Account findByUsername(String accountName);

    @Query()
    boolean isTaskOwner(Long accountId, Long taskId);//TODO

    void insertUserRole(Long accountId, Role role);//TODO

}
