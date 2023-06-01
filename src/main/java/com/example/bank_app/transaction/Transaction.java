package com.example.bank_app.transaction;

import com.example.bank_app.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transaction {
    @Id @GeneratedValue
    private Integer id;
    private BigDecimal montant;
    private String destination;
    private TransactionType type;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user1;
}
