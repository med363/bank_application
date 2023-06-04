package com.example.bank_app.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Set;
@Getter
/*builder construire un objet*/
@Builder
@AllArgsConstructor
/*includ les att a besoin*/
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ExceptionResponse {
    private String errMsg;
    private String errSrc;
    private Set<String> validationErr;
    private String sth;
}
