package com.example.bank_app.user;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    /*definir les attribut que je doit utiliser dans userMapper*/
    private Integer id;
    private  String firstname;
    private  String lastname;
    private String email;
    private String password;
    private String iban;
    private boolean active;
}
