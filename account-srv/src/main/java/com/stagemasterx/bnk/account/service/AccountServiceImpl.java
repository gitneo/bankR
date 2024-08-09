package com.stagemasterx.bnk.account.service;

import com.stagemasterx.bnk.account.dto.AccountCreationRequest;
import static com.stagemasterx.bnk.account.mapper.AccountMapper.*;
import com.stagemasterx.bnk.account.model.Account;
import com.stagemasterx.bnk.account.model.AccountHolder;
import com.stagemasterx.bnk.account.repository.AccountHolderRepository;
import com.stagemasterx.bnk.account.repository.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final AccountHolderRepository accountHolderRepository;

    @Override
    public void createAccount(AccountCreationRequest accountCreationRequest) {
        AccountHolder accountHolder = this
                .accountHolderRepository
                .save(toAccountHolder(accountCreationRequest.accountRequester()));

        this.accountRepository.save(toAccount(accountCreationRequest,accountHolder));
    }

    @Override
    public Account getAccount(Integer accountId) {
        return null;
    }

    @Override
    public List<Account> getAllAccounts() {
        return List.of();
    }

    @Override
    public void updateAccount(Account account) {

    }

    @Override
    public void deleteAccount(Integer accountId) {

    }
}
