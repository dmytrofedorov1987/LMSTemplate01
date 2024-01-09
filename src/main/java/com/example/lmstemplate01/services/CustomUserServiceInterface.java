package com.example.lmstemplate01.services;


public interface CustomUserServiceInterface {
    void createUser(CustomUserDTO customUserDTO);

    void updateUser(CustomUserDTO customUserDTO);

    void deleteUser(Long id);

    CustomUserDTO retrieveUser(Long id);
}
