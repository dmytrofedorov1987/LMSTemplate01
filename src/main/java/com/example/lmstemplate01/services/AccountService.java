package com.example.lmstemplate01.services;

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

    @Transactional
    @Override
    public void createAccount(AccountDTO accountDTO) {
        Account account = Account.fromAccountDTO(accountDTO);
        accountRepository.save(account);
    }

    @Transactional
    @Override
    public AccountDTO getAccountByUsername(String username) {
        Account account = accountRepository.findByUsername(username);
        return account.toAccountDTO();
    }

    @Transactional
    @Override
    public void updateAccount(AccountDTO accountDTO, Long id) {
        Account account = getAccountFromOptional(id);
        account.setUsername(accountDTO.getUsername());
        account.setEmail(accountDTO.getEmail());
        account.setPassword(accountDTO.getPassword());
        accountRepository.save(account);
    }

    @Transactional
    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    @Transactional
    @Override
    public AccountDTO getAccount(Long id) {
        Account account = getAccountFromOptional(id);
        return account.toAccountDTO();
    }

    @Transactional
    @Override
    public List<AccountDTO> getAllAccounts() {// Need to retrieve PageRequest?
        List<Account> users = accountRepository.findAll();
        List<AccountDTO> usersDTO = new ArrayList<>();
        users.forEach(a -> usersDTO.add(a.toAccountDTO()));
        return usersDTO;
    }

    @Transactional
    @Override
    public long count() {
        return accountRepository.count();
    }

    /**
     * Method searches and receive an Account by ID.
     *
     * @param id
     * @return Account
     */
    private Account getAccountFromOptional(Long id) {
        Optional<Account> accountOpt = accountRepository.findById(id);
        Account account = new Account();
        if (accountOpt.isPresent()) {
            account = accountOpt.get();
        }
        return account;
    }
}
