package com.example.bank_app.contact;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class ContactResponse {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    /*iban user commence seullement TN <> iban contact puisque iban commence par DE TN FR ..*/
    private String iban;
}
