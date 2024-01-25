package com.example.lmstemplate01.controllers;

import com.example.lmstemplate01.dto.AccountDTO;
import com.example.lmstemplate01.dto.ResultDTOPackege.BadResultDTO;
import com.example.lmstemplate01.dto.ResultDTOPackege.ResultDTO;
import com.example.lmstemplate01.dto.ResultDTOPackege.SuccessResultDTO;
import com.example.lmstemplate01.services.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping
    public AccountDTO createAccount(@Valid @RequestBody AccountDTO accountDTO) {
        return accountService.createAccount(accountDTO);
    }

    @PatchMapping("/{id}")
    public AccountDTO updateAccount(@PathVariable(value = "id") Long accountId,
                                    @Valid @RequestBody  AccountDTO accountDTO) {
        return accountService.updateAccount(accountDTO, accountId);
    }

    @DeleteMapping("/{id}")//TODO what response needs?
    public ResponseEntity<ResultDTO> deleteAccount(@PathVariable(value = "id") Long accountId) {
        accountService.deleteAccount(accountId);
        return new ResponseEntity<>(new SuccessResultDTO(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public AccountDTO retrieveAccount(@PathVariable(value = "id") Long accountId) {
        return accountService.getAccount(accountId);
    }

    @GetMapping("all")
    public List<AccountDTO> getAllAccounts() {// TODO Need to retrieve PageRequest?
        return accountService.getAllAccounts();
    }

    /**
     * The method throws an exception if it receives uncorrected JSON or null.
     *
     * @return ResponseEntity
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResultDTO> handleException() {
        return new ResponseEntity<>(new BadResultDTO(), HttpStatus.BAD_REQUEST);
    }

}
