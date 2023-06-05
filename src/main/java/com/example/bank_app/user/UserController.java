package com.example.bank_app.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;
    /*creation account besoin iban w userId*/
    /*lors de la creation de l'iban il envois new response --> on applique le pattern CQRS -->divise resp et req*/
    @PostMapping
    /*return l'id de l'account cree*/
    public Integer save(@RequestBody UserRequest userRequest){

        return  service.create(userRequest);
    }
//on veut absorbe <> exception a chaque controllers donc on besoin de faire class exceptiion handlers global dans le package globalExceptionHandlers*/

    //recouve l'entity
    @GetMapping
    //@ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<List<UserResponse>> findAll(){
        // return ResponseEntity.status(200).body(service.finfAll());
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{user-id}")
    public ResponseEntity<UserResponse> findById(
            @PathVariable("user-id") Integer id
    ){
        return ResponseEntity.ok(service.findById(id));
    }
    /*active/desactive-> patch*/
    @PatchMapping("/activate/{user-id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Integer validate(
            @PathVariable("user-id") Integer id
    ){
       return service.validateAccount(id);
    }

    @PatchMapping("/invalidate/{user-id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Integer Invalidate(
            @PathVariable("user-id") Integer id
    ){
        return service.invalidateAccount(id);
    }
}
