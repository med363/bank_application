package com.example.bank_app.account;

import com.example.bank_app.user.User;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Account {
    @Id @GeneratedValue
    private Integer id;
    @Column(unique = true)
    private String iban;
    @OneToOne
    /*ajout foreign key je l'appel user_id or sprint l'a cree automatiquement*/
    @JoinColumn(name = "user_id")
    private User user;

}
