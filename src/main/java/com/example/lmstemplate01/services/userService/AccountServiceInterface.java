package com.example.lmstemplate01.services.userService;


import com.example.lmstemplate01.web.dto.user.AccountDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AccountServiceInterface {
    AccountDTO createAccount(AccountDTO accountDTO);

    AccountDTO updateAccount(AccountDTO accountDTO, Long id);

    void deleteAccount(Long id);

    AccountDTO getAccount(Long id);

    List<AccountDTO> getAllAccounts(Pageable pageable);

    boolean isTaskOwner(Long accountId, Long taskId);

    long count();
}
