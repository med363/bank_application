package com.example.bank_app.contact;

import com.example.bank_app.user.User;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Contact {
    @Id @GeneratedValue
    private Integer id;
    private String firstname;
    private String lastname;
    @Column(unique = true)
    private String email;
    private String iban;
    /*relation entre contact et user ==> list de contact => many contact , appartient a un seul user*/
    @ManyToOne
    /*foegein key*/
    @JoinColumn(name = "user_id")
    private User user1;
}
