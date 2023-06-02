package com.example.bank_app.user;

import com.example.bank_app.account.Account;
import com.example.bank_app.contact.Contact;
import com.example.bank_app.role.Role;
import com.example.bank_app.transaction.Transaction;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {
    @Id @GeneratedValue
    private Integer id;
    private String fistname;
    private String lastname;
    @Column(unique = true)
    private String email;
    private String password;
    private Boolean active;
/*relation avec table account==>chaque user has one account*/
    @OneToOne
    private Account account;
/*relation avec table contact==>chaque user has many contact [list of contact]*/
    /*dima oneToMany on ajout mapped by pour specifer quel table user il se peut on a pls table user*/
    @OneToMany(mappedBy = "user1")
    private List<Contact> contactList;
    /*relation avec table transaction==>chaque user has many transaction [list of transaction]*/
    @OneToMany(mappedBy = "user1")
    private List<Transaction> transactionList;
    /*relation avec table role==>many user has many role [list of role]*/
    /*definir table de jointure*/
    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )

    private List<Role> roleList;


}
