package com.example.bank_app.account;

import com.example.bank_app.exception.ObjectValidationException;
import com.example.bank_app.validator.ObjectsValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountRequestValidatorTest {
    private final ObjectsValidator<AccountRequest> validator = new ObjectsValidator<>();
    @Test
    public void  should_return_err_msg(){
        var exp=assertThrows(ObjectValidationException.class, ()-> validator.validate((AccountRequest.builder().build())));
    /*verifier content of exception*/
        assertEquals(1,exp.getValidation().size());
        assertEquals("AccountRequest",exp.getValidationSource());
    }
}
