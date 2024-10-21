package org.bank.digitalbanking.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@DiscriminatorValue(value = "SA")
@PrimaryKeyJoinColumn(name = "id")
public class SavingAccount extends BankAccount{

    private double interestRate;

}
