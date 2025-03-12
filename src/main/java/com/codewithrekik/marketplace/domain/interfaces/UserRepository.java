package com.codewithrekik.marketplace.domain.interfaces;

import com.codewithrekik.marketplace.domain.entities.User;
/**
 * This interface defines the contract for accessing and persisting User entities.
 * It provides methods for finding users and saving new or updated users.
 * The specific implementation of this interface will handle the interaction with the underlying data store (e.g., MongoDB).
 */
public interface UserRepository {
    /**
     * Finds a user by their username.
     *
     * @param username The username to search for
     * @return The User object if found, otherwise null
     */
    User findByUsername(String username);
    /**
     * Saves a user entity. If the user is new, it will be inserted.
     * If the user already exists, it will be updated.
     *
     * @param user The User object to save
     * @return The saved User object
     */
    User save(User user);
}