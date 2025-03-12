package com.codewithrekik.marketplace.domain.interfaces;

import com.codewithrekik.marketplace.domain.entities.User;
/**
 * This interface defines the contract for validating User entities.
 * Implementations of this interface will provide the logic for determining

 */

public interface UserValidator {

    /**
     * Checks if a User object is valid.
     *
     * @param user The User object to validate
     * @return true if the user is valid, false otherwise
     */
    boolean isValid(User user);

}