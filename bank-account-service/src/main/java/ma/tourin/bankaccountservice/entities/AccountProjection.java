package ma.tourin.bankaccountservice.entities;

import ma.tourin.bankaccountservice.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class,name="p1")  //http://localhost:8082/bankAccounts?projection=p1
public interface AccountProjection {
    public String getId();
    public AccountType getType();
    public Double getBalance();
}
// Rest ne permet pas de faire choisir les colonnes que je veux ms je peux faire la projection if I want
// avec graphql les projections sont précisés dans la requete

