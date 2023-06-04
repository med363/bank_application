package com.example.bank_app.contact;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ContactRequest implements Serializable {
private Integer id;

@NotNull(message="first name is mandatory ")
private String firstname;
private String lastname;
@Email(message = "should be valid email")
private String email;
/*iban user commence seullement TN <> iban contact puisque iban commence par DE TN FR ..*/
private String iban;
private Integer userId;
}
