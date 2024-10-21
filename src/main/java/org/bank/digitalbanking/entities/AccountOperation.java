package org.bank.digitalbanking.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bank.digitalbanking.entities.enums.OperationType;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class AccountOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @DateTimeFormat(pattern = "YYYY-mm-dd")
    private Date date;
    private double amount;
    private OperationType type;
    @ManyToOne
    private  BankAccount bankAccount;
}
