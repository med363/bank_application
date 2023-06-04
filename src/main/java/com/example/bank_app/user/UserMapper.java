package com.example.bank_app.user;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserMapper {
    public User toUser(UserRequest request){
        return User.builder()
                .id(request.getId())
                .fistname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }
    /*create methode toResponse in class userService on l'appel*/
    public UserResponse toResponse(User User){
        return UserResponse.builder()
                .id(User.getId())
                .firstname(User.getFistname())
                .lastname(User.getLastname())
                .email(User.getEmail())
                .active(User.getActive())
                .iban(User.getAccount().getIban())
                .password(User.getPassword()).build();

    }
}
