package com.stagemasterx.bnk.account.mapper;

import com.stagemasterx.bnk.account.dto.AccountCreationRequest;
import com.stagemasterx.bnk.account.dto.AccountRequester;
import com.stagemasterx.bnk.account.model.Account;
import com.stagemasterx.bnk.account.model.AccountHolder;

import java.util.UUID;

public class AccountMapper {

    public static Account toAccount(AccountCreationRequest accountRequest, AccountHolder accountRequester){
       return Account
               .builder()
               .accountHolder(accountRequester)
               .accountNo(UUID.randomUUID())
               .type(accountRequest.type())
               .currency(accountRequest.currency())
               .balance(accountRequest.balance())
               .build();
    }

    public static AccountHolder toAccountHolder(AccountRequester accountRequester){
        return AccountHolder
                .builder()
                .firstName(accountRequester.firstName())
                .lastName(accountRequester.lastName())
                .build();
    }
}
