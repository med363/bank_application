package com.example.bank_app.account;

import com.example.bank_app.user.User;
import org.springframework.stereotype.Component;

/* class beans*/
@Component

public class AccountMapper {
    /*methode generale transfert de lèobjet req vers account*/
    public static Account toAccount(AccountRequest request){
        /*transformer de l'objet vers Account*/
        var account = Account.builder()
                .iban(request.getIban())
                .user(User.builder()
                        .id(request.getUserId())
                        .build())
                .build();
        return account;
    }
}
