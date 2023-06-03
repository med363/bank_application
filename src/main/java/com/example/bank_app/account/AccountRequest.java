package com.example.bank_app.account;

import com.example.bank_app.user.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AccountRequest implements Serializable {
    /*create account il suffit de l'iban w l'id of user*/

    @NotNull(message = "IBAN should not be null") // null
    @NotEmpty(message = "IBAN should not be empty") // ""
    @NotBlank(message = "IBAN should not be blank") // " "
    private String iban;
    @NotNull(message = "user should not be null")
    private Integer userId;


}
