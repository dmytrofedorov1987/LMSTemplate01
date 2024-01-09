package com.example.lmstemplate01.services;


import com.example.lmstemplate01.dto.AccountDTO;

public interface AccountServiceInterface {
    void createAccount(AccountDTO accountDTO);

    void updateAccount(AccountDTO accountDTO, Long id);

    void deleteAccount(Long id);

    AccountDTO getAccount(Long id);

    long count();
}
