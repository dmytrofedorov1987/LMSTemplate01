package com.example.lmstemplate01.dto;

import com.example.lmstemplate01.passwordValidator.ValidPassword;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * DataTransferObject class for working with Accounts.
 */
@Data
public class AccountDTO {
    private Long id;
    private String username;
    @ValidPassword
    private String password;
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
