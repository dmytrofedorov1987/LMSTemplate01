package com.example.lmstemplate01.web.dto.user;


import com.example.lmstemplate01.web.dto.validators.passwordValidator.ValidPassword;
import com.example.lmstemplate01.web.dto.validators.uniqueValidators.FieldUnique;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * DataTransferObject class for working with Accounts.
 */
@Getter
@Setter
public class AccountDTO {
    private Long id;
    @FieldUnique(field = "username", table = "Account")
    private String username;
    @ValidPassword
    private String password;
    @FieldUnique(field = "email", table = "Account")
    private String email;

    private List<String> rolesId = new ArrayList<>();

    @JsonCreator
    public AccountDTO(@JsonProperty String username,
                      @JsonProperty String password,
                      @JsonProperty String email,
                      @JsonProperty List<String> rolesId) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.rolesId = rolesId;
    }

    public AccountDTO() {
    }

    public AccountDTO(Long id, String username, String password, String email, List<String> rolesId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.rolesId = rolesId;
    }
}
