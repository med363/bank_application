package com.example.bank_app.account;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer>{
/*l'existance d'un objet Acoont*/
    boolean existsByUserId(Integer userId);
}
