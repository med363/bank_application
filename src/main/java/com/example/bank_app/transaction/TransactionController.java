package com.example.bank_app.transaction;

import com.example.bank_app.contact.ContactResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService service;
    /*creation account besoin iban w userId*/
    /*lors de la creation de l'iban il envois new response --> on applique le pattern CQRS -->divise resp et req*/
    @PostMapping
    /*return l'id de l'account cree*/
    public Integer save(@RequestBody TransactionRequest transaction){

        return  service.create(transaction);
    }
//on veut absorbe <> exception a chaque controllers donc on besoin de faire class exceptiion handlers global dans le package globalExceptionHandlers*/

    //recouve l'entity
    @GetMapping("/user/{user-id}")
    //@ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<Transaction>> findAll(
            @PathVariable("user-id") Integer id
    ){
        // return ResponseEntity.status(200).body(service.finfAll());
        return ResponseEntity.ok(service.findAllByUser(id));
    }



}
