package com.example.lmstemplate01.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * DataTransferObject class for working with Accounts.
 */
@Data
public class AccountDTO {
    private Long id;
    private String accountName;
    private String password;
    private String email;

    @JsonCreator
    public AccountDTO(@JsonProperty String accountName,
                      @JsonProperty String password,
                      @JsonProperty String email) {
        this.accountName = accountName;
        this.password = password;
        this.email = email;
    }

    public AccountDTO(Long id, String accountName, String password, String email) {
        this.id = id;
        this.accountName = accountName;
        this.password = password;
        this.email = email;
    }

}
