package com.example.bank_app.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountMapperTest {
    /*je veut test accountMapper -> cree un objet de l'account mapper*/
    private final AccountMapper mapper = new AccountMapper();
    /*tous les test sont de type void*/
    @Test
    public void should_map_from_Account_request_to_Account(){
        var req = AccountRequest.builder()
                .userId(1)
                .build();
        /*je veut stocker cet objet ds un variable account*/
        var account = mapper.toAccount(req);
        /*verifier ce variable est correcter mapper from AccountRequest to Account afin de le verifier not null*/
        Assertions.assertNotNull(account);
        /*l'objet user not null*/
        Assertions.assertNotNull(account.getUser());
        /*l'objet user il faut que l'id =1*/
        Assertions.assertEquals(1,account.getUser().getId());
        /*VERIFIER IBAN NO vide*/
        Assertions.assertNull(account.getIban());
    }


}