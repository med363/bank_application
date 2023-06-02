package com.example.bank_app.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private AccountRepository repository;
    /*cree un account*/
    public Integer save(Account account){
        return repository.save(account).getId();
    }
}
