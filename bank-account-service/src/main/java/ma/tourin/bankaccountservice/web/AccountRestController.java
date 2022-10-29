package ma.tourin.bankaccountservice.web;

import ma.tourin.bankaccountservice.dto.BankAccountRequestDTO;
import ma.tourin.bankaccountservice.dto.BankAccountResponseDTO;
import ma.tourin.bankaccountservice.entities.BankAccount;
import ma.tourin.bankaccountservice.mappers.AccountMapper;
import ma.tourin.bankaccountservice.repositories.BankAccountRepository;
import ma.tourin.bankaccountservice.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class AccountRestController {

    // @Autowired déconseillé
    private BankAccountRepository bankAccountRepository;
    private AccountService accountService;
    private AccountMapper accountMapper;

    public AccountRestController(BankAccountRepository bankAccountRepository, AccountService accountService, AccountMapper accountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }

    @GetMapping("/bankAccounts") //smiya dyal entité c est la norme restfull
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id ){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account not found",id)));
    }

   /* @PostMapping("/bankAccounts")
    public BankAccount save(@RequestBody BankAccount bankAccount){
        if(bankAccount.getId()==null)
            bankAccount.setId(UUID.randomUUID().toString());
        return bankAccountRepository.save(bankAccount);
    }*/

    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO bankAccount){
       return accountService.addAccount(bankAccount);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id,@RequestBody BankAccount bankAccount){
        BankAccount account = bankAccountRepository.findById(id).orElseThrow();
        //put et patsh at the same time
        //model mappers can do that
        if (bankAccount.getBalance()!=null)
            account.setBalance(bankAccount.getBalance());
        if (bankAccount.getCreatedAt()!=null)
            account.setCreatedAt(bankAccount.getCreatedAt());
        if (bankAccount.getType()!=null)
            account.setType(bankAccount.getType());
        if (bankAccount.getCurrency()!=null)
            account.setCurrency(bankAccount.getCurrency());

        return bankAccountRepository.save(account);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void delete(@PathVariable String id){

        bankAccountRepository.deleteById(id);

    }
}
