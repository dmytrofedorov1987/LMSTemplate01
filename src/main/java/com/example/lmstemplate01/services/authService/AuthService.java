package com.example.lmstemplate01.services.authService;

import com.example.lmstemplate01.web.dto.auth.JwtRequest;
import com.example.lmstemplate01.web.dto.auth.JwtResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements AuthServiceInterface{

    @Override
    public JwtResponse login(JwtRequest loginRequest) {
        return null;
    }

    @Override
    public JwtResponse refresh(String refreshToken) {
        return null;
    }
}
