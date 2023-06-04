package com.example.bank_app.contact;

import com.example.bank_app.validator.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactService {
    private final ContactRepository repository;
    private final ObjectsValidator<ContactRequest> validator;
    private final ContactMapper mapper;

    /*post*/
    public Integer create(ContactRequest request){
        validator.validate(request);
        var contact = mapper.toContact(request);
        return repository.save(contact).getId();
    }

    /*getAll*/
    public List<ContactResponse> findAllByUser(Integer userId){
        return repository.findAllByUserId()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    /*getbyId*/
    public ContactResponse findById(Integer contactId){
        return  repository.findById(contactId)
                .map(mapper::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("no contact found with id" + contactId));
    }

    /*delete*/
    public void delete(Integer contactId){
        repository.deleteById(contactId);

    }
}
