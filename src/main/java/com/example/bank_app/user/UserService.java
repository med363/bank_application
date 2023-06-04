package com.example.bank_app.user;

import com.example.bank_app.account.Account;
import com.example.bank_app.account.AccountRequest;
import com.example.bank_app.account.AccountService;
import com.example.bank_app.validator.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final ObjectsValidator<UserRequest> validator;
    private final UserMapper mapper;
    private final AccountService accountService;

    /*post*/
    public Integer create(UserRequest request){
        /*necessaire de faire validation de chaque request*/
        validator.validate(request);
        var user = mapper.toUser(request);
        return repository.save(user).getId();
    }

    /*getAll*/
    public List<UserResponse> findAll(){
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    /*getONE*/
    public UserResponse findById(Integer id){
        return repository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(()-> new EntityNotFoundException("no user ID"));
    }

    /*delete*/
    public void delete(Integer id){
        repository.deleteById(id);
    }

    //verif active user
    public Integer validateAccount(Integer userId){
        var user = repository.findById(userId)
                .orElseThrow(()-> new EntityNotFoundException("no user ID for account validation"));
        /*check has account or no*/
        if (user.getAccount() == null){
            //create a bank account
            var account = AccountRequest.builder()
                    .userId(userId)
                    .build();
            var saveAccountId = accountService.create(account);
            /*add accountID IN table user*/
            user.setAccount(
                    Account.builder()
                            .id(saveAccountId)
                            .build()
            );
       }
        //if has an account donc j'active user seullment
        user.setActive(true);
        return repository.save(user).getId();
    }

    //desactive an account
    public Integer invalidateAccount(Integer userId){
        var user = repository.findById(userId)
                .orElseThrow(()-> new EntityNotFoundException("no user ID for account validation"));
        user.setActive(false);
        return repository.save(user).getId();

    }
}
