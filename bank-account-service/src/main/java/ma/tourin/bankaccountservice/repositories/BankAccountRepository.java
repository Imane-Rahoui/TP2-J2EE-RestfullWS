package ma.tourin.bankaccountservice.repositories;

import ma.tourin.bankaccountservice.entities.BankAccount;
import ma.tourin.bankaccountservice.enums.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource // stp demarre moi un web service restfull // create put post ... ect
public interface BankAccountRepository extends JpaRepository<BankAccount,String> {

    //  http://localhost:8082/bankAccounts
    // c paginé => http://localhost:8082/bankAccounts?page=0&size=2

    @RestResource(path="/byType") // MTN http://localhost:8082/bankAccounts/search/byType?t=CURRENT_ACCOUNT
    List<BankAccount> findByType(@Param("t") AccountType type); // sans creer une methide pour l utiliser au nv du controller
    // http://localhost:8082/bankAccounts/search/findByType?type=CURRENT_ACCOUNT

}
