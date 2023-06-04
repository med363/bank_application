package com.example.bank_app.account;

import com.example.bank_app.user.User;
import com.example.bank_app.validator.ObjectsValidator;
import lombok.RequiredArgsConstructor;
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
    public Integer save(AccountRequest accountRequest){
/*validation*/
        validator.validate(accountRequest);
        return repository.save(mapper.toAccount(accountRequest)).getId();
    }
    /*get-> list of account (AcoountResponce c'est class contient ls att id of account ,iban and owner of iban*/
    /*finAll -> object account or on veut un objet de type AccountResponse donc on cree une methode de mapper dans la class AccountMapper*/
    public List<AccountResponce> finfAll(){
        return repository.findAll()
                .stream().map(mapper::toResponse)
                .collect(Collectors.toList());
    }
}
