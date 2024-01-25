package com.example.lmstemplate01.services;


import com.example.lmstemplate01.dto.AccountDTO;

import java.util.List;

public interface AccountServiceInterface {
    AccountDTO createAccount(AccountDTO accountDTO);

    AccountDTO updateAccount(AccountDTO accountDTO, Long id);

    void deleteAccount(Long id);

    AccountDTO getAccount(Long id);

    List<AccountDTO> getAllAccounts();// Need to retrieve PageRequest?

    long count();
}
