package com.example.bank_app.account;

import com.example.bank_app.exception.ObjectValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return  service.create(account);
    }
//on veut absorbe <> exception a chaque controllers donc on besoin de faire class exceptiion handlers global dans le package globalExceptionHandlers*/

    //recouve l'entity
    @GetMapping
    //@ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<AccountResponce>> findAll(){
        // return ResponseEntity.status(200).body(service.finfAll());
        return ResponseEntity.ok(service.finfAll());
    }

    @GetMapping("/{account-id}")
    public ResponseEntity<AccountResponce> findById(
            @PathVariable("account-id") Integer id
    ){
        return ResponseEntity.ok(service.finById(id));
    }
    @DeleteMapping("/{account-id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(
            @PathVariable("account-id") Integer id
    ){
service.delete(id);
    }

}
