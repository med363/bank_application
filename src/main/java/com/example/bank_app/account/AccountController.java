package com.example.bank_app.account;

import com.example.bank_app.exception.ObjectValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/*pour dire que c'est un controller*/
@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {
    /*use methode save in class service*/
    private final AccountService service;
    /*creation account besoin iban w userId*/
    /*lors de la creation de l'iban il envois new response --> on applique le pattern CQRS -->divise resp et req*/
    @PostMapping
    /*return l'id de l'account cree*/
    public Integer save(@RequestBody AccountRequest account){
        return  service.save(account);
    }
/*absorbe l'exception system*/
    @ExceptionHandler(ObjectValidationException.class)
    public String handleException(ObjectValidationException exp){
        return "err ....";

    }

}
