package com.example.bank_app.account;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AccountRequest {
    /*create account il suffit de l'iban w l'id of user*/


    private String iban;
    private Integer userId;
}
