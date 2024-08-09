package com.stagemasterx.bnk.account.dto;

import com.stagemasterx.bnk.account.AccountType;
import com.stagemasterx.bnk.account.model.AccountHolder;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;

import java.util.UUID;

@Builder
public record AccountCreationRequest(
        AccountRequester accountRequester,
        @Enumerated(EnumType.STRING)
        AccountType type,
        String currency,
        double balance
) {}
