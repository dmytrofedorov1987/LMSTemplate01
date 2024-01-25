package com.example.lmstemplate01.model;

import com.example.lmstemplate01.dto.AccountDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)//TODO create exception while occur unique
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true)//TODO create exception while occur unique
    @Email
    private String email;
    @OneToMany(mappedBy = "account")
    private List<Role> roles = new ArrayList<>();

    public Account() {
    }

    public Account(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public static Account of(String username, String password, String email) {
        return new Account(username, password, email);
    }

    public static Account fromAccountDTO(AccountDTO accountDTO) {
        return Account.of(accountDTO.getUsername(), accountDTO.getPassword(), accountDTO.getEmail());
    }

    public AccountDTO toAccountDTO() {
        return new AccountDTO(id, username, password, email);
    }

}
