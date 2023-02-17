package com.sebastian.portfolio.model.exceptions;

/**
 *
 * @author Sebastian Charras
 */
public class PersonNotFoundException extends RuntimeException {

    public PersonNotFoundException(Integer id) {
        super("Could not find person with id " + id);
    }
}
