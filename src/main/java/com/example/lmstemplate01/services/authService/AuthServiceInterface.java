package com.example.lmstemplate01.services.authService;

import com.example.lmstemplate01.web.dto.auth.JwtRequest;
import com.example.lmstemplate01.web.dto.auth.JwtResponse;

public interface AuthServiceInterface {

    JwtResponse login(JwtRequest loginRequest);

    JwtResponse refresh(String refreshToken);
}
