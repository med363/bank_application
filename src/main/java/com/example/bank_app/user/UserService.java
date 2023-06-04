package com.example.bank_app.user;

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
    public Integer save(UserRequest request){
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
    public Integer validateAccount(Integer id){
        var user = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("no user ID for account validation"));
        /*check has account or no*/
        if (user.getAccount() == null){
            //create a bank account
            var account = AccountRequest.builder()
                    .userId(id)
                    .build();
            accountService.save(account);
        }

        return -1;
    }
}
