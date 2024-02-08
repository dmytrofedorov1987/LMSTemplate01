package com.example.lmstemplate01.services;

import com.example.lmstemplate01.configurations.MapperAccount;
import com.example.lmstemplate01.dto.AccountDTO;
import com.example.lmstemplate01.model.Account;
import com.example.lmstemplate01.repositoryJPA.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService implements AccountServiceInterface {
    private final AccountRepository accountRepository;
    private final MapperAccount mapperAccount;

    @Transactional
    @Override
    public AccountDTO createAccount(AccountDTO accountDTO) {
        Account account = mapperAccount.toAccount(accountDTO);
        accountRepository.save(account);
        return mapperAccount.toAccountDTO(account);
    }

    @Transactional
    @Override
    public AccountDTO updateAccount(AccountDTO accountDTO, Long id) {
        Account account = accountRepository.findById(id).orElseThrow();
        account.setUsername(accountDTO.getUsername());
        account.setEmail(accountDTO.getEmail());
        account.setPassword(accountDTO.getPassword());//TODO

        accountRepository.save(account);
        return mapperAccount.toAccountDTO(account);
    }

    @Transactional
    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public AccountDTO getAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow();
        return mapperAccount.toAccountDTO(account);
    }

    @Transactional(readOnly = true)
    @Override
    public List<AccountDTO> getAllAccounts() {// Need to retrieve PageRequest?
        List<Account> users = accountRepository.findAll();
        List<AccountDTO> usersDTO = new ArrayList<>();
        users.forEach(account -> usersDTO.add(mapperAccount.toAccountDTO(account)));
        return usersDTO;
    }

    @Transactional(readOnly = true)
    @Override
    public long count() {
        return accountRepository.count();
    }

}
