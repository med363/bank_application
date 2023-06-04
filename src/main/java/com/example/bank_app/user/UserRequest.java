package com.example.bank_app.user;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest implements Serializable {
    /*definir les attribut que je doit utiliser dans userMapper*/
    private Integer id;
    private  String firstname;
    private  String lastname;
    private String email;
    private String password;
}
