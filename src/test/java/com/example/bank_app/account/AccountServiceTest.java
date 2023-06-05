package com.example.bank_app.account;

import com.example.bank_app.user.User;
import com.example.bank_app.validator.ObjectsValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AccountServiceTest {
    @Mock
    /*on a deux façon d'implimenter les tests unitaire soit -> cree instance soit -> mocking*/
    private  AccountRepository repository;
    @Mock
    private   AccountMapper mapper;
    @Mock
    /*mich n3adilo accountRequest por le valider*/
    private  ObjectsValidator<AccountRequest> validator;
    /*account service besoin de trois dependences */
    @InjectMocks
    private AccountService service;
    /*aa9bal kol test methode ->before each test methode*/
    @BeforeEach
    public void setup(){
        /*ouvre ce ces mock dans la classe en cours*/
        MockitoAnnotations.openMocks(this);
    }
    /*methode test*/
    @Test
    public void should_create_account(){
        /*objet account && request*/
        var request = AccountRequest.builder()
                .userId(1)
                .build();
        var account =  Account.builder()
                .id(10)
                .user(User.builder().id(1).build())
                .build();
        /*appel lil repo id =1 raja3 false*/
        /*ce test dans le cas user hav'nt an account*/
        when(repository.existsByUserId(request.getUserId()))
                .thenReturn(false);
        when(mapper.toAccount(request)).thenReturn(account);
        /*generate iban -> mock appel lil repo*/
        when(repository.existsByIban(anyString()))
                .thenReturn(false);
        /*mocky il entity il saaaved*/
        when(repository.save(account)).thenReturn(account);
        var id = service.create(request);
        verify(validator).validate(request);
        verify(mapper).toAccount(request);
        verify(repository).existsByUserId(request.getUserId());
        verify(repository.existsByIban(notNull()));
        verify(repository.save(account));
        /*lazmo iraja3 l'id =10*/
        assertEquals(10,id);



    }

}