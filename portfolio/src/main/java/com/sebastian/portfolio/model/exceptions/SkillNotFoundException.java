package com.sebastian.portfolio.model.exceptions;

/**
 *
 * @author Sebastian Charras
 */
public class SkillNotFoundException extends RuntimeException {

    public SkillNotFoundException(Integer id) {
        super("Could not find skill with id " + id);
    }
}
