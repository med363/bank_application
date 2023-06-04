package com.example.bank_app.handler;

import com.example.bank_app.exception.ObjectValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//ecouteur du controllers
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ObjectValidationException.class)
    /*status http*/
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public  ExceptionResponse handle(ObjectValidationException exp){
        var expResp = ExceptionResponse.builder()
                .errMsg("object not valid")
                .errSrc(exp.getValidationSource())
                .validationErr(exp.getValidation())
                .build();
        return expResp;
    }

}
