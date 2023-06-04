package com.example.bank_app.transaction;

import com.example.bank_app.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Transaction {
    @Id @GeneratedValue
    private Integer id;
    private BigDecimal montant;
    private String destination;
    private LocalDate dateTx;
    /*il faut que de type string transert-->'1' Deposit-->'2'*/
    @Enumerated(EnumType.STRING)
    private TransactionType type;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user1;


}
