package ma.tourin.bankaccountservice.mappers;

import ma.tourin.bankaccountservice.dto.BankAccountResponseDTO;
import ma.tourin.bankaccountservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){

        // framework comme mapstruct or model mapper OR
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(
                bankAccount,bankAccountResponseDTO
        );
        return bankAccountResponseDTO;
    }
}
