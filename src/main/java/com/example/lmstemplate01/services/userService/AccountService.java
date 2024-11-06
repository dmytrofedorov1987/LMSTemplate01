/*package com.example.lmstemplate01.services.userService;

import com.example.lmstemplate01.web.dto.user.AccountDTO;
import com.example.lmstemplate01.model.user.Account;
import com.example.lmstemplate01.repositoryJPA.userRepository.AccountRepository;
import com.example.lmstemplate01.repositoryJPA.userRepository.RoleRepository;
import com.example.lmstemplate01.model.exceptions.MLSTemplateRuntimeException;
import com.example.lmstemplate01.web.mappers.UserMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService implements AccountServiceInterface {
    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;

    @Transactional
    @Override
    public AccountDTO createAccount(AccountDTO accountDTO) {
        if (accountRepository.existsByUsername(accountDTO.getUsername())) {
            throw new MLSTemplateRuntimeException("User with name " + accountDTO.getUsername() + " exists.");
        }
        Account account = new Account();
        if (!(accountDTO.getRolesId().isEmpty())) {
            Account finalAccount = account;
            accountDTO.getRolesId().forEach(roleId ->
                    finalAccount.addRole(roleRepository.findById(roleId)
                            .orElseThrow(() -> new EntityNotFoundException("Role with id " + roleId + " not found"))));
        }
        account = userMapper.toEntity(accountDTO);
        accountRepository.save(account);
        return userMapper.toDto(account);
    }


    @Transactional
    @Override
    public AccountDTO updateAccount(AccountDTO accountDTO, Long id) {
        Account account = accountRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Account with id " + id + " not found"));
        if (!(accountDTO.getUsername() == null)) {
            account.setUsername(accountDTO.getUsername());
        }
        if (!(accountDTO.getEmail() == null)) {
            account.setEmail(accountDTO.getEmail());
        }
        if (!(accountDTO.getPassword() == null)) {
            account.setPassword(accountDTO.getPassword());
        }
        if (!(accountDTO.getRoles().isEmpty())) {
            accountDTO.getRoles().forEach(roleId ->
                    account.addRole(roleRepository.findById(roleId)
                            .orElseThrow(() -> new EntityNotFoundException("Role with id " + roleId + " not found"))));
        }
        accountRepository.save(account);
        return mapperAccount.toAccountDTO(account);
    }

    @Transactional
    @Override
    public void deleteAccount(Long id) {
        if (accountRepository.existsById(id)) {
            accountRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Account doesn't exist.");
        }
    }

    @Transactional(readOnly = true)
    @Override
    public AccountDTO getAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Account with id " + id + " not found"));
        return mapperAccount.toAccountDTO(account);
    }

    @Transactional(readOnly = true)
    @Override
    public List<AccountDTO> getAllAccounts() {
        List<Account> users = accountRepository.findAll();
        if (!users.isEmpty()) {
            List<AccountDTO> usersDTO = new ArrayList<>();
            users.forEach(account -> usersDTO.add(mapperAccount.toAccountDTO(account)));
            return usersDTO;
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Transactional(readOnly = true)
    @Override
    public long count() {
        return accountRepository.count();
    }

}

 */
