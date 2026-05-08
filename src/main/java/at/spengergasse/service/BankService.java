package at.spengergasse.service;

import at.spengergasse.domain.Account;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class BankService {
    private ArrayList<Account> accounts;

    public BankService() {
        accounts = new ArrayList<>();
        fillTestData(100);
    }

    public void fillTestData(int count) {
        String[] accounttypes = {"Checking", "Savings", "Fixed Deposit", "Business", "Joint"};
        Account a;
        Faker faker = new Faker();
        String firstName;
        LocalDate openingDate;
        String accountType;
        Double amount;
        Boolean active;

        for(int i = 0; i < count; i++){
            firstName = faker.address().firstName();
            openingDate = LocalDate.now().minusDays((int) Math.random() * 3650);
            accountType = accounttypes[faker.random().nextInt(accounttypes.length -1)];
            amount = faker.number().randomDouble(2,0,50000);
            active = faker.bool().bool();
            a = new Account(firstName, openingDate, accountType, amount, active);
            accounts.add(a);
        }

    }

    public ArrayList<Account> findAll(){
        ArrayList<Account> copy = new ArrayList<>(accounts);
        return copy;
    }

    @Override
    public String toString() {
        return accounts.stream()
                .map(s -> s.toString())
                .collect(Collectors.joining("\n"));
    }

    public void removeAllAccounts() {
        accounts.clear();
    }
}
