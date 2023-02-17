package com.sebastian.portfolio.model.advices;

import com.sebastian.portfolio.model.exceptions.InstitutionNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Sebastian Charras
 */
@ControllerAdvice
public class InstitutionNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(InstitutionNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String institutionNotFoundHandler(InstitutionNotFoundException ex) {
        return ex.getMessage();
    }
}
