package com.stagemasterx.bnk.account;

import com.stagemasterx.bnk.account.dto.AccountCreationRequest;
import com.stagemasterx.bnk.account.service.AccountServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/account")
public class AccountServiceDesk {

    private final AccountServiceImpl accountService;

    public AccountServiceDesk(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<String> createAccount(@RequestBody AccountCreationRequest request) {
        this.accountService.createAccount(request);
        return ResponseEntity.ok("Account created successfully");
    }
}
