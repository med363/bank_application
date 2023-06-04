package com.example.bank_app.account;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountResponce {
    /*return l'id de l'account a ete cree*/
    private Integer id;
    private String iban;
    /*owner of iban*/
    private String userFirstname;
    private String userLastname;

}
