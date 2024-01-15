package com.example.lmstemplate01.services;


import com.example.lmstemplate01.dto.AccountDTO;

import java.util.List;

public interface AccountServiceInterface {
    void createAccount(AccountDTO accountDTO);

    void updateAccount(AccountDTO accountDTO, Long id);

    void deleteAccount(Long id);

    AccountDTO getAccount(Long id);

    AccountDTO getAccountByUsername(String username);

    List<AccountDTO> getAllAccounts();// Need to retrieve PageRequest?

    long count();
}
