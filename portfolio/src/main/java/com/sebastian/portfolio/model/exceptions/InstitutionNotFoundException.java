package com.sebastian.portfolio.model.exceptions;

/**
 *
 * @author Sebastian Charras
 */
public class InstitutionNotFoundException extends RuntimeException {

    public InstitutionNotFoundException(Integer id) {
        super("Could not find institution with id " + id);
    }
}
