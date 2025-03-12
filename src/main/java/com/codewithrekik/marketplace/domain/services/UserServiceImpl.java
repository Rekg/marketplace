package com.codewithrekik.marketplace.domain.services;

import com.codewithrekik.marketplace.domain.entities.User;
import com.codewithrekik.marketplace.domain.interfaces.UserRepository;
import org.springframework.stereotype.Service;
/**
 * This class implements the UserService interface, providing the business logic
 * for user registration. It interacts with the UserRepository to persist user data.
 */
@Service // This annotation marks this class as a Spring service component
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository; // The repository used to access and persist user data
    /**
     * Constructor for UserServiceImpl, injecting the UserRepository dependency.
     *
     * @param userRepository The repository for accessing and persisting user data
     */
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    /**
     * Registers a new user.
     *
     * @param user The User object to register
     * @return The registered User object
     */
    @Override
    public User registerUser(User user) {
        // pass

        // Save the user to the repository
        return userRepository.save(user);
    }
}