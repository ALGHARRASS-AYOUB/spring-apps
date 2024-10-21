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
//@DiscriminatorValue(value = "CA")
@PrimaryKeyJoinColumn(name = "id")
public class CurrentAccount extends  BankAccount{
    private double overDraft;
}
