package com.example.bank_app.account;

import com.example.bank_app.user.User;
import com.example.bank_app.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*permet de charger tout le  context spring (demrrer tout les conteneur spring-> permet de faire ds injection classic avec Autowired*/
@SpringBootTest
public class AccountServiceSpringTest {
    @Autowired
    private AccountService service;
    @Autowired
    private UserRepository userRepository;
    @Test
    public void should_create_account() {
        /*save fake user ds db*/
        var savedUser = userRepository.save(User.builder().fistname("Amine").build());
        /*objet account && request*/
        var request = AccountRequest.builder()
                .userId(savedUser.getId())
                .build();
        var id = service.create(request);
        /*lazmo iraja3 l'id =1*/
        assertEquals(1, id);
    }


    }
