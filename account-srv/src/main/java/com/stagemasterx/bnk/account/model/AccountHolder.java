package com.stagemasterx.bnk.account.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

@Table
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountHolder {

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "accountHolder-sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "accountHolderTableSeq", value = "accountHolder_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Column(name = "acth_id", unique = true, nullable = false)
    private Long id;
    @Column(name = "acth_first_name")
    private String firstName;
    @Column(name = "acth_last_name")
    private String lastName;
    @OneToMany(mappedBy = "accountHolder")
    private List<Account> accounts = new ArrayList<>();
}
