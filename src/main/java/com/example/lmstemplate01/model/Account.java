package com.example.lmstemplate01.model;

import com.example.lmstemplate01.dto.AccountDTO;
import com.example.lmstemplate01.dto.RoleDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Username can not be empty and should be unique.")
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    @Email(message = "Email should be valid and unique.")
    private String email;
    @OneToMany(mappedBy = "account")
    private List<Role> roles = new ArrayList<>();

    public Account() {
    }

    public Account(String username, String password, String email, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }
    public void addRole(Role role){
        roles.add(role);
        role.setAccount(this);
    }
/*
    public static Account of(String username, String password, String email, List<Role> roles) {
        return new Account(username, password, email, roles);
    }

    public static Account fromAccountDTO(AccountDTO accountDTO) {
        return Account.of(accountDTO.getUsername(), accountDTO.getPassword(), accountDTO.getEmail(), accountDTO.getRoles());
    }

    public AccountDTO toAccountDTO() {
        return new AccountDTO(id, username, password, email, roles);
    }
    // TODO Here i create a method for convert Json to string and backwards.

 */


}
