package com.sebastian.portfolio.model.exceptions;

/**
 * @author Sebastian Charras
 */
public class ProjectNotFoundException extends RuntimeException {

    public ProjectNotFoundException(Integer id) {
        super("Could not find project with id " + id);
    }
}
