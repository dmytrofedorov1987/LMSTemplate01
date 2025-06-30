package com.example.lmstemplate01.web.dto.auth;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JwtRequest {
    @NotNull(message = "Username must be not null.")
    private String username;
    @NotNull(message = "Password must be not null.")
    private String password;

}
