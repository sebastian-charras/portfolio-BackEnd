package com.sebastian.portfolio.model.exceptions;

/**
 *
 * @author Sebastian Charras
 */
public class EducationNotFoundException extends RuntimeException {

    public EducationNotFoundException(Integer id) {
        super("Could not find education with id " + id);
    }

}
