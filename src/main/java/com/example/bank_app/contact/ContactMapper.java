package com.example.bank_app.contact;

import com.example.bank_app.user.User;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {

    public Contact toContact(ContactRequest request) {
        return Contact.builder()
                .id(request.getId())
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .iban(request.getIban())
                /*id of user*/
                .user1((
                        User.builder()
                                .id(request.getUserId())
                                .build()
                        ))
                .build();
    }

    public ContactResponse toResponse(Contact contact){
        return ContactResponse.builder()
                .id(contact.getId())
                .firstname(contact.getFirstname())
                .lastname(contact.getLastname())
                .email(contact.getEmail())
                .iban(contact.getIban())
                .build();

    }
}
