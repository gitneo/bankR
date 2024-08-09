package com.stagemasterx.bnk.account.service;

import com.stagemasterx.bnk.account.dto.AccountCreationRequest;
import com.stagemasterx.bnk.account.model.Account;

import java.util.List;

public interface AccountService {
    public void createAccount(AccountCreationRequest accountCreationRequest);
    public Account getAccount(Integer accountId);
    public List<Account> getAllAccounts();
    public void updateAccount(Account account);
    public void deleteAccount(Integer accountId);
}
