package com.example.lmstemplate01.dto;


import com.example.lmstemplate01.model.Account;
import com.example.lmstemplate01.repositoryJPA.AccountRepository;
import com.example.lmstemplate01.validators.passwordValidator.ValidPassword;
import com.example.lmstemplate01.validators.uniqueValidators.FieldEquals;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.util.Optional;

/**
 * DataTransferObject class for working with Accounts.
 */
@Data
public class AccountDTO {
    private Long id;
    @FieldEquals(field = "username")
    private String username;
    @ValidPassword
    private String password;
    @FieldEquals(field = "email")
    private String email;

    @JsonCreator
    public AccountDTO(@JsonProperty String username,
                      @JsonProperty String password,
                      @JsonProperty String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public AccountDTO(Long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
