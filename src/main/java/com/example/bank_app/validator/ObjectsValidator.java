package com.example.bank_app.validator;

import com.example.bank_app.account.AccountRequest;
import com.example.bank_app.exception.ObjectValidationException;
import jakarta.validation.*;
import org.springframework.stereotype.Service;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;
/*pour etre un class generique il suffit de mettre <T>*/
/*Service pour l'injecter dans les class que je souhaite*/
@Service
public class ObjectsValidator<T extends Serializable> {
    /*class validatr factory*/
    private final ValidatorFactory factory= Validation.buildDefaultValidatorFactory();
    /*recuper validator du class factory*/
    private final Validator validator = factory.getValidator();
    /*methde de validation les objets*/
    public void validate(T objectToValidate){
        /*return l'ensemble des fields  non valid en se bassant sur les message que je mettre*/
        Set<ConstraintViolation<T>> validation = validator.validate(objectToValidate);
        if (!validation.isEmpty()){
           Set<String> errMSG = validation
                   .stream()
                   .map(ConstraintViolation::getMessage)
                   .collect(Collectors.toSet());
           /*exception*/
            throw new ObjectValidationException(errMSG, objectToValidate.getClass().getSimpleName());
        }
    }
}
