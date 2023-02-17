package com.sebastian.portfolio.model.advices;

import com.sebastian.portfolio.model.exceptions.PersonNotFoundException;
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
public class PersonNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(PersonNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String personNotFoundHandler(PersonNotFoundException ex) {
        return ex.getMessage();
    }
}
