package com.example.bank_app.handler;

import com.example.bank_app.exception.ObjectValidationException;
import com.example.bank_app.exception.OperationNonPermittedExcption;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//ecouteur du controllers
@RestControllerAdvice
//log *>class logger
@Slf4j
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
/*exception in mthode find by Id*/
    @ExceptionHandler(EntityNotFoundException.class)
    /*status http*/
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public  ExceptionResponse handle(EntityNotFoundException exp){
        var expResp = ExceptionResponse.builder()
                .errMsg(exp.getMessage())
                .build();
        return expResp;
    }

    /*exception in mthode verify active user*/
    @ExceptionHandler(OperationNonPermittedExcption.class)
    /*status http*/
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public  ExceptionResponse handle(OperationNonPermittedExcption exp){
        var expResp = ExceptionResponse.builder()
                .errMsg(exp.getMessage())
                .build();
        return expResp;
    }
/*capter n'import quelle exception*/
    @ExceptionHandler(Exception.class)
    /*status http*/
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public  ExceptionResponse handle(Exception exp){
        // log
        log.error("error accurred",exp);
        var expResp = ExceptionResponse.builder()
                .errMsg("Oups, persistance err ,contact the admin")
                .build();
        return expResp;
    }
}
