package com.example.lmstemplate01.configurations;

import com.example.lmstemplate01.dto.AccountDTO;
import com.example.lmstemplate01.model.Account;
import com.example.lmstemplate01.model.Role;
import com.example.lmstemplate01.repositoryJPA.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Class with methods for converting Account to AccountDTO and back.
 */
@Component
@RequiredArgsConstructor
public class MapperAccount {
    private final RoleRepository roleRepository;

    public AccountDTO toAccountDTO(Account account) {
        List<String> idRoles = account
                .getRoles()
                .stream()
                .map(Role::getId)
                .toList();
        return new AccountDTO(account.getId(), account.getUsername(), account.getPassword(), account.getEmail(), idRoles);
    }

    public Account toAccount(AccountDTO accountDTO) {
        List<Role> roles = accountDTO
                .getRoles()
                .stream()
                .map(this::getRoleFromOptional)
                .toList();
        Account account = new Account(accountDTO.getUsername(), accountDTO.getPassword(), accountDTO.getEmail());
        roles.forEach(role -> account.addRole(role));
        return account;
    }

    /**
     * Method searches and receive a Role by ID.
     *
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
