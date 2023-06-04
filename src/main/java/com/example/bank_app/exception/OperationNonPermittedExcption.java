package com.example.bank_app.exception;

import lombok.NoArgsConstructor;


public class OperationNonPermittedExcption extends RuntimeException{
    /*parent super RuntimeException*/
    public OperationNonPermittedExcption(String message){
        super(message);
    }
}
