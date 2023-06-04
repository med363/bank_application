package com.example.bank_app.transaction;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionRequest implements Serializable {
    /*montant il faut etre positive*/
    @Positive
    /*min montant */
    @Min(1)
    private BigDecimal montant;
    private String destination;
    private TransactionType type;
    /*user transaction done*/
    private Integer userId;

}
