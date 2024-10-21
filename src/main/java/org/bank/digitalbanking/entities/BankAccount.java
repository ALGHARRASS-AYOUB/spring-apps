package org.bank.digitalbanking.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bank.digitalbanking.entities.enums.AccountStatus;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "type", length = 4,discriminatorType = DiscriminatorType.STRING)
public abstract class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String currency;
    private double balance;
    @DateTimeFormat(pattern = "YYYY-mm-dd")
    private Date createdAt;
    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    @ManyToOne
    private Customer customer;
    @OneToMany(mappedBy = "bankAccount")
    private List<AccountOperation> accountOperations;


}
