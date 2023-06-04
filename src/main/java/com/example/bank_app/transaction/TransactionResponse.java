package com.example.bank_app.transaction;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionResponse implements Serializable {
    private BigDecimal montant;
    private String destination;
    private TransactionType type;
    private LocalDate dateTx;
}
