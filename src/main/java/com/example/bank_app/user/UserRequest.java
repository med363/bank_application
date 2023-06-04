package com.example.bank_app.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
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
    @Email(message = "Email is not valid")
    private String email;
    /*min 4 et max 16 caractere */
    @Size(min = 4, max = 16, message = "Password should be between 8 and 16")
    private String password;
}
