package org.bank.digitalbanking.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bank.digitalbanking.entities.BankAccount;
import org.bank.digitalbanking.entities.CurrentAccount;
import org.bank.digitalbanking.entities.Customer;
import org.bank.digitalbanking.entities.SavingAccount;
import org.bank.digitalbanking.entities.enums.AccountStatus;
import org.bank.digitalbanking.repositories.AccountOperationRepository;
import org.bank.digitalbanking.repositories.BankAccountRepository;
import org.bank.digitalbanking.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Configuration
@Data @AllArgsConstructor
public class initialize implements CommandLineRunner {

    CustomerRepository customerRepository;
    BankAccountRepository bankAccountRepository;
    AccountOperationRepository accountOperationRepository;

    @Override
    public void run(String... args) throws Exception {
        Stream
                .of("ayoub","ahmed","lina","anas","ismail","yousra","imane","saloua","said","salim","souad","naima")
                .forEach(name -> {
                        SavingAccount sa=new SavingAccount();
                        CurrentAccount acc=new CurrentAccount();
                    Customer c=new Customer();
                        c.setId(UUID.randomUUID().toString());
                        c.setFirstName(name);
                        c.setSecondName(name);
                        c.setEmail(name+"@mail.com");
                        c.setPhone("+2120000000");
                    customerRepository.save(c);

                    if (name.startsWith("s")){
                        List<BankAccount> accounts=new ArrayList<>();
                        sa.setId(UUID.randomUUID().toString());
                        sa.setBalance(9000);
                        sa.setCurrency("MAD");
                        sa.setStatus(AccountStatus.ACTIVATED);
                        sa.setCreatedAt(new Date());
                        sa.setInterestRate(4.2);
//                        sa.setCustomer(c);
                        bankAccountRepository.save(sa);
//                        accounts.add(sa);
//                        c.setBankAccounts(accounts);
                    }else {
                        List<BankAccount> accounts=new ArrayList<>();
                        acc.setId(UUID.randomUUID().toString());
                        acc.setBalance(Math.random()*100000);
                        acc.setCurrency("MAD");
                        acc.setStatus(AccountStatus.ACTIVATED);
                        acc.setCreatedAt(new Date());
                        acc.setOverDraft(9000);

//                        acc.setCustomer(c);
                        bankAccountRepository.save(acc);
//                        accounts.add(acc);
//                        c.setBankAccounts(accounts);
//                        customerRepository.save(c);
                    }

                });
    }
}
