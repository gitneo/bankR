package com.stagemasterx.bnk.account.model;

import com.fasterxml.jackson.annotation.JsonValue;
import com.stagemasterx.bnk.account.AccountType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.naming.Name;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "account")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "accountTableSeq", value = "account_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Column(name = "acct_id", unique = true, nullable = false)
    private long id;

    @JoinColumn(name = "acct_holder_id", nullable = false)
    @ManyToOne
    private AccountHolder accountHolder;

    @Column(name = "acct_no", unique = true, nullable = false)
    private UUID accountNo;

    @Enumerated(EnumType.STRING)
    @Column(name = "acct_type")
    private AccountType type;

    @Column(name = "acct_bal", nullable = false)
    private double balance;

    @Column(name = "acct_curr", nullable = false)
    private String currency;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id && Double.compare(balance, account.balance) == 0 && Objects.equals(accountHolder, account.accountHolder) && Objects.equals(accountNo, account.accountNo) && type == account.type && Objects.equals(currency, account.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountHolder, accountNo, type, balance, currency);
    }
}
