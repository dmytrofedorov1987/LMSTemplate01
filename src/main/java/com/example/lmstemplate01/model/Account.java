package com.example.lmstemplate01.model;

import com.example.lmstemplate01.dto.AccountDTO;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String accountName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;

    public Account() {
    }

    public Account(String accountName, String password, String email) {
        this.accountName = accountName;
        this.password = password;
        this.email = email;
    }

    public static Account of(String accountName, String password, String email) {
        return new Account(accountName, password, email);
    }

    public static Account fromAccountDTO(AccountDTO accountDTO) {
        return Account.of(accountDTO.getAccountName(), accountDTO.getPassword(), accountDTO.getEmail());
    }
    public AccountDTO toAccountDTO(){
        return new AccountDTO(id, accountName, password, email);
    }

}
