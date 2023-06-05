package com.example.bank_app.account;

import com.example.bank_app.exception.ObjectValidationException;
import com.example.bank_app.validator.ObjectsValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountRequestValidatorTest {
    private final ObjectsValidator<AccountRequest> validator = new ObjectsValidator<>();
    @Test
    public void  should_return_err_msg(){
        var exp=assertThrows(ObjectValidationException.class, ()-> validator.validate((AccountRequest.builder().build())));
    /*verifier content of exception*/
        assertEquals(1,exp.getValidation().size());
        assertTrue(exp.getValidation().contains("user should not be null"));
        assertEquals("AccountRequest",exp.getValidationSource());
    }
}
