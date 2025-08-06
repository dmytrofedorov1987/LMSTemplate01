package com.example.lmstemplate01.web.dto.user;


import com.example.lmstemplate01.web.dto.validators.OnCreate;
import com.example.lmstemplate01.web.dto.validators.OnUpdate;
import com.example.lmstemplate01.web.dto.validators.passwordValidator.ValidPassword;
import com.example.lmstemplate01.web.dto.validators.uniqueValidators.FieldUnique;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

/**
 * DataTransferObject class for working with Accounts.
 */
@Getter
@Setter
public class AccountDTO {

    @NotNull(message = "Id must be not null", groups = OnUpdate.class)
    private Long id;

    @NotNull(message = "UserName must be not null", groups = {OnUpdate.class, OnCreate.class})
    @Length(max = 255, message = "UserName must be smaller than 255 symbols", groups = {OnUpdate.class, OnCreate.class})
    @FieldUnique(field = "username", table = "Account")
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password must be not null", groups = {OnUpdate.class, OnCreate.class})
    @ValidPassword
    private String password;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password must be not null", groups = OnCreate.class)
    @ValidPassword
    private String confirmPassword;

    @FieldUnique(field = "email", table = "Account")
    private String email;

    @JsonCreator
    public AccountDTO(@JsonProperty String username,
                      @JsonProperty String password,
                      @JsonProperty String confirmPassword,
                      @JsonProperty String email) {
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.email = email;
    }

    public AccountDTO() {
    }

    public AccountDTO(Long id, String username, String password, String confirmPassword, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.email = email;
    }
}
