package org.bank.digitalbanking.repositories;

import org.bank.digitalbanking.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
