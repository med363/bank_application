package com.example.bank_app.account;

import com.example.bank_app.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private AccountRepository repository;
    /*cree un account*/
    public Integer save(AccountRequest accountRequest){
        /*transformer de l'objet vers Account*/
        var account = Account.builder()
                .iban(accountRequest.getIban())
                .user(User.builder()
                        .id(accountRequest.getUserId())
                        .build())
                .build();
        return repository.save(account).getId();
    }
}
