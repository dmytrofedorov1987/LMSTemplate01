package com.example.lmstemplate01.dto;


import com.example.lmstemplate01.validators.passwordValidator.ValidPassword;
import com.example.lmstemplate01.validators.uniqueValidators.FieldUnique;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * DataTransferObject class for working with Accounts.
 */
@Data
public class AccountDTO {
    private Long id;
    @FieldUnique(field = "username", table = "Account")
    private String username;
    @ValidPassword
    private String password;
    @FieldUnique(field = "email", table = "Account")
    private String email;
    private String roles; //TODO

    @JsonCreator
    public AccountDTO(@JsonProperty String username,
                      @JsonProperty String password,
                      @JsonProperty String email,
                      @JsonProperty String roles) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }

    public AccountDTO() {
    }

    public AccountDTO(Long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
