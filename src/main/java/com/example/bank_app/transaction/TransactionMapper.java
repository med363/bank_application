package com.example.bank_app.transaction;

import com.example.bank_app.user.User;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {
    public Transaction toTransaction(TransactionRequest request){
return Transaction.builder()
        .montant(request.getMontant())
        .type(request.getType())
        /*id of user*/
        .user1((
                User.builder()
                        .id(request.getUserId())
                        .build()
        ))
        .destination(request.getDestination())
        .build();
    }

    public Transaction toResponse (Transaction transaction){
        return Transaction.builder()
                .montant(transaction.getMontant())
                .type(transaction.getType())
                .destination(transaction.getDestination())
                .dateTx(transaction.getDateTx())
                .build();


    }

}
