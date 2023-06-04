package com.example.bank_app.transaction;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionRequest implements Serializable {
    private BigDecimal montant;
    private String destination;
    private TransactionType type;
    /*user transaction done*/
    private Integer userId;

}
