package com.example.bank_app.account;

import com.example.bank_app.user.User;
import com.example.bank_app.validator.ObjectsValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository repository;
    private final  AccountMapper mapper;
    /*mich n3adilo accountRequest por le valider*/
    private final ObjectsValidator<AccountRequest> validator;

    /*cree un account*/
    public Integer save(AccountRequest accountRequest){
/*validation*/
        validator.validate(accountRequest);
        return repository.save(mapper.toAccount(accountRequest)).getId();
    }
}
