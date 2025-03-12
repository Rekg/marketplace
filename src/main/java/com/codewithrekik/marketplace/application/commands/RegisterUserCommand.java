package com.codewithrekik.marketplace.application.commands;

import com.codewithrekik.marketplace.application.dtos.UserRegistrationDTO;
/**
 * This class represents the command to register a new user.
 * It encapsulates the user registration data in a UserRegistrationDTO object.

 */
public class RegisterUserCommand {
    private final UserRegistrationDTO userRegistrationDTO; // The DTO containing user registration data

    /**
     * Constructor for RegisterUserCommand.
     *
     * @param userRegistrationDTO The DTO containing user registration data
     */
    public RegisterUserCommand(UserRegistrationDTO userRegistrationDTO) {
        this.userRegistrationDTO = userRegistrationDTO;
    }
    /**
     * Returns the UserRegistrationDTO associated with this command.
     *
     * @return The UserRegistrationDTO object
     */
    public UserRegistrationDTO getUserRegistrationDTO() {
        return userRegistrationDTO;
    }
}