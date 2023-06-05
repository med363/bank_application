package com.example.bank_app.account;

import com.example.bank_app.user.User;
import org.springframework.stereotype.Component;

/* class beans*/
@Component

public class AccountMapper {
    /*methode generale transfert de lèobjet req vers account*/
    public  Account toAccount(AccountRequest request){
        /*pour que test handle null req*/
        if(request == null){
            return new Account();
        }
        /*transformer de l'objet vers Account*/
        var account = Account.builder()
                .user(User.builder()
                        .id(request.getUserId())
                        .build())
                .build();
        return account;
    }

    public  AccountResponce toResponse(Account account){
        /*transformer de l'objet vers AccountResponse*/
        var accountRes = AccountResponce.builder()
                .id(account.getId())
                .iban(account.getIban())
                .userFirstname(account.getUser().getFistname())
                .userLastname(account.getUser().getLastname())
                .build();

        return accountRes;
    }
    //ctr+shift+t-> test
}
