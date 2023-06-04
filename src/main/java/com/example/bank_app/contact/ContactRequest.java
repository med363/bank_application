package com.example.bank_app.contact;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ContactRequest implements Serializable {
private Integer id;
private String firstname;
private String lastname;
private String email;
/*iban user commence seullement TN <> iban contact puisque iban commence par DE TN FR ..*/
private String iban;
private Integer userId;
}
