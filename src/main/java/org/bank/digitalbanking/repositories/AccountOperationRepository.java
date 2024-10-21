package org.bank.digitalbanking.repositories;

import org.bank.digitalbanking.entities.AccountOperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountOperationRepository extends JpaRepository<AccountOperation,String> {
}
