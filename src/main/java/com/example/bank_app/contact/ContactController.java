package com.example.bank_app.contact;

import com.example.bank_app.account.AccountRequest;
import com.example.bank_app.account.AccountResponce;
import com.example.bank_app.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/contacts")
@RequiredArgsConstructor

public class ContactController {
    private final ContactService service;
    /*creation account besoin iban w userId*/
    /*lors de la creation de l'iban il envois new response --> on applique le pattern CQRS -->divise resp et req*/
    @PostMapping
    /*return l'id de l'account cree*/
    public Integer save(@RequestBody ContactRequest contact){

        return  service.create(contact);
    }
//on veut absorbe <> exception a chaque controllers donc on besoin de faire class exceptiion handlers global dans le package globalExceptionHandlers*/

    //recouve l'entity
    @GetMapping("/user/{user-id}")
    //@ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<ContactResponse>> findAll(
            @PathVariable("user-id") Integer id
    ){
        // return ResponseEntity.status(200).body(service.finfAll());
        return ResponseEntity.ok(service.findAllByUser(id));
    }

    @GetMapping("/{contact-id}")
    public ResponseEntity<ContactResponse> findById(
            @PathVariable("contact-id") Integer id
    ){
        return ResponseEntity.ok(service.findById(id));
    }
    @DeleteMapping("/{contact-id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(
            @PathVariable("contact-id") Integer id
    ){
        service.delete(id);
    }

}
