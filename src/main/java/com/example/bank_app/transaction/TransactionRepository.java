package com.example.bank_app.transaction;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
}
