package com.example.bank_app.transaction;

import com.example.bank_app.contact.ContactResponse;
import com.example.bank_app.validator.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository repository;
    private final ObjectsValidator<TransactionRequest> validator;
    private final TransactionMapper mapper;

    /*post*/
    public Integer create(TransactionRequest request){
        validator.validate(request);
        var transaction = mapper.toTransaction(request);
        var multiplier = BigDecimal.valueOf(getTransactionMultiplier(request.getType()));
        /*selon typpe de transaction +montant or -montant*/
        var montantToSavee = request.getMontant().multiply(multiplier);
        transaction.setMontant(montantToSavee);
        return repository.save(transaction).getId();
    }

    /*selon typpe de transaction +montant or -montant*/
    private int getTransactionMultiplier(TransactionType type){
        //if type de transaction == transfert nraj3 -1 sinon nraja3 1
        return TransactionType.TRANSFERT == type ? -1 : 1;
    }

    /*getAll*/
    public List<Transaction> findAllByUser(Integer userId){
        return repository.findAllByUserId(userId)
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }


}
