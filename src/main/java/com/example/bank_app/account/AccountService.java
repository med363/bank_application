package com.example.bank_app.account;

import com.example.bank_app.user.User;
import com.example.bank_app.validator.ObjectsValidator;
import com.example.bank_app.exception.OperationNonPermittedExcption;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository repository;
    private final  AccountMapper mapper;
    /*mich n3adilo accountRequest por le valider*/
    private final ObjectsValidator<AccountRequest> validator;

    /*cree un account->post*/
    public Integer create(AccountRequest accountRequest){

/*validation*/
        validator.validate(accountRequest);
        /*transfert to accountRequest*/
        var account = mapper.toAccount(accountRequest);
        /*check if user have an account*/
        var userHasAllreadyAnAccount = repository.existsByUserId(accountRequest
                .getUserId());
        /*test if active and have alleready an account*/
        if (userHasAllreadyAnAccount ){
            throw new OperationNonPermittedExcption("the selected user has allready an active account");
        }
        account.setIban(generateRandomIban());
        return repository.save(mapper.toAccount(accountRequest)).getId();
    }
    /*get-> list of account (AcoountResponce c'est class contient ls att id of account ,iban and owner of iban*/
    /*finAll -> object account or on veut un objet de type AccountResponse donc on cree une methode de mapper dans la class AccountMapper*/
    /*methode transactionnel puisque onetoone fetch mode eager or ontomany fetch mode lazy*/
    //@Transactional
    public List<AccountResponce> finfAll(){
        return repository.findAll()
                .stream().map(mapper::toResponse)
                .collect(Collectors.toList());
    }
    public AccountResponce finById(Integer id){
        return  repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(()-> new EntityNotFoundException("No Account found with ID"));
    }

    public void delete(Integer id){
        // check before
         repository.deleteById(id);
    }
    /*methde generat random iban*/
    private String generateRandomIban(){
        /*generate en boucle iban of country code jusqu'a iban no in use*/
        var iban = Iban.random(CountryCode.TN).toFormattedString();
        /*CHECK iban exist allready or not --> add sth in AccountRepository*/
        if(repository.existsByIban(iban)){
            //if true -> generate new iban
            generateRandomIban();
        }
        // if not exist return iban
        return  iban;
    }
}

