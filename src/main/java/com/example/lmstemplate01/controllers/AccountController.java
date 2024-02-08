package com.example.lmstemplate01.controllers;

import com.example.lmstemplate01.dto.AccountDTO;
import com.example.lmstemplate01.services.AccountService;
import com.example.lmstemplate01.utils.MLSTemplateError;
import com.example.lmstemplate01.utils.MLSTemplateRuntimeException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<?> createAccount(@Valid @RequestBody AccountDTO accountDTO) {
        try {
            AccountDTO accountDTto = accountService.createAccount(accountDTO);
            return ResponseEntity.ok(accountDTto);
        } catch (MLSTemplateRuntimeException ex) {
            return ResponseEntity.ok(
                    new MLSTemplateError(HttpStatus.BAD_REQUEST.value(),
                            "Incorrect data."));
        }
    }

    @PatchMapping("/{id}")
    public AccountDTO updateAccount(@PathVariable(value = "id") Long accountId,
                                    @Valid @RequestBody AccountDTO accountDTO) {//TODO
        return accountService.updateAccount(accountDTO, accountId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable(value = "id") Long accountId) {
        try {
            accountService.deleteAccount(accountId);
            return ResponseEntity.ok(new MLSTemplateError(HttpStatus.OK.value(),
                    "The user has been deleted."));
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.ok(
                    new MLSTemplateError(HttpStatus.NOT_FOUND.value(),
                            "User with id " + accountId + " is not found."));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> retrieveAccount(@PathVariable(value = "id") Long accountId) {
        try {
            AccountDTO accountDTO = accountService.getAccount(accountId);
            return ResponseEntity.ok(accountDTO);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.ok(
                    new MLSTemplateError(HttpStatus.NOT_FOUND.value(),
                            "User with id " + accountId + " is not found."));
        }
    }

    @GetMapping("all")
    public ResponseEntity<?> getAllAccounts() {
        try {
            List<AccountDTO> list = accountService.getAllAccounts();
            return ResponseEntity.ok(list);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.ok(
                    new MLSTemplateError(HttpStatus.NOT_FOUND.value(),
                            "There are no users."));
        }
    }

}
