package com.codewithrekik.marketplace.application.commands;

import com.codewithrekik.marketplace.application.dtos.UserRegistrationDTO;
import com.codewithrekik.marketplace.application.interfaces.CommandHandler;
import com.codewithrekik.marketplace.domain.entities.User;
import com.codewithrekik.marketplace.domain.interfaces.UserValidator;
import com.codewithrekik.marketplace.domain.services.UserService;
import com.codewithrekik.marketplace.infrastructure.persistance.UserRepositoryImpl;
import org.springframework.stereotype.Service;
/**
 * This class handles the RegisterUserCommand, orchestrating the user registration process.
 * It validates the user data, converts it to a User entity, and then delegates
 * the registration to the UserService.
 */
@Service
public class RegisterUserCommandHandler implements CommandHandler<RegisterUserCommand> {
    private final UserService userService;
    private final UserValidator userValidator;
    private final UserRepositoryImpl userRepository;
    /**
     * Constructor for RegisterUserCommandHandler, injecting dependencies.
     *
     * @param userService     The UserService for user registration
     * @param userValidator   The UserValidator for validating user data
     * @param userRepository  The UserRepository for user persistence (Note: This is not directly used in the command handler, but is injected because it is in the constructor.)
     */
    public RegisterUserCommandHandler(UserService userService, UserValidator userValidator, UserRepositoryImpl userRepository) {
        this.userService = userService;
        this.userValidator = userValidator;
        this.userRepository = userRepository;
    }

    @Override
    public void handle(RegisterUserCommand command) {
        UserRegistrationDTO dto = command.getUserRegistrationDTO();
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword()); // Remember to hash this!
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());

        if (userValidator.isValid(user)) {
            userService.registerUser(user);
        } else {
            throw new RuntimeException("User data is invalid.");
        }
    }
}