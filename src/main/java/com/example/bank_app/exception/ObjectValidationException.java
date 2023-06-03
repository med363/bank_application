package com.example.bank_app.exception;
/*il ya deux type d'exception checkedException -->au moment de la compilation / incheckedException --> au moment de l'excution */

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
public class ObjectValidationException extends RuntimeException{
    @Getter
    private final Set<String> validation;
    @Getter
    private final String validationSource;

}
