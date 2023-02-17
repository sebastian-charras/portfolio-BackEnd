package com.sebastian.portfolio.model.advices;

import com.sebastian.portfolio.model.exceptions.SkillNotFoundException;
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
public class SkillNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(SkillNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String skillNotFoundHandler(SkillNotFoundException ex) {
        return ex.getMessage();
    }
}
