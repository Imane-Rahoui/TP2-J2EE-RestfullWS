package ma.tourin.bankaccountservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.tourin.bankaccountservice.enums.AccountType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {

    @Id
    private String id;

    private Date createdAt;

    private Double balance; //val par def c null et non pas 0.0 comme vc double

    private String currency;

    @Enumerated(EnumType.STRING)
    private AccountType type;
}
