package com.sebastian.portfolio.model.exceptions;

/**
 * @author Sebastian Charras
 */
public class WorkExperienceNotFoundException extends RuntimeException {

    public WorkExperienceNotFoundException(Integer id) {
        super("Could not find work experience with id " + id);
    }

}
