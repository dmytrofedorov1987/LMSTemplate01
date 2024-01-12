package com.example.lmstemplate01.controllers;

import com.example.lmstemplate01.dto.AccountDTO;
import com.example.lmstemplate01.dto.ResultDTOPackege.BadResultDTO;
import com.example.lmstemplate01.dto.ResultDTOPackege.ResultDTO;
import com.example.lmstemplate01.dto.ResultDTOPackege.SuccessResultDTO;
import com.example.lmstemplate01.services.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<ResultDTO> createAccount(@RequestBody AccountDTO accountDTO) {
        accountService.createAccount(accountDTO);
        return new ResponseEntity<>(new SuccessResultDTO(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResultDTO> updateAccount(@PathVariable(value = "id") Long accountId,
                                                   @RequestBody AccountDTO accountDTO) {
        accountService.updateAccount(accountDTO, accountId);
        return new ResponseEntity<>(new SuccessResultDTO(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResultDTO> deleteAccount(@PathVariable(value = "id") Long accountId) {
        accountService.deleteAccount(accountId);
        return new ResponseEntity<>(new SuccessResultDTO(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public AccountDTO retrieveAccount(@PathVariable(value = "id") Long accountId) {
        return accountService.getAccount(accountId);
    }


    /**
     * The method throws an exception if it receives uncorrected JSON or null.
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResultDTO> handleException() {
        return new ResponseEntity<>(new BadResultDTO(), HttpStatus.BAD_REQUEST);
    }

}
