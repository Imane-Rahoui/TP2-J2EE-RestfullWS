package ma.tourin.bankaccountservice.service;

import ma.tourin.bankaccountservice.dto.BankAccountRequestDTO;
import ma.tourin.bankaccountservice.dto.BankAccountResponseDTO;
import ma.tourin.bankaccountservice.entities.BankAccount;
import ma.tourin.bankaccountservice.enums.AccountType;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDto);
}
