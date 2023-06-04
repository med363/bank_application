package com.example.bank_app.contact;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact,Integer> {
    List<Contact>findAllByUserId();
}
