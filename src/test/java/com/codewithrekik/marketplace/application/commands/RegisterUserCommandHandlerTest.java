package com.codewithrekik.marketplace.application.commands;

import com.codewithrekik.marketplace.application.dtos.UserRegistrationDTO;
import com.codewithrekik.marketplace.domain.entities.User;
import com.codewithrekik.marketplace.domain.interfaces.UserValidator;
import com.codewithrekik.marketplace.domain.services.UserService;
import com.codewithrekik.marketplace.infrastructure.persistance.UserRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
/**
 * This class contains unit tests for the RegisterUserCommandHandler.
 * It uses Mockito to mock the dependencies (UserService and UserValidator)
 * and verify the interactions between the command handler and its dependencies.
 */
@ExtendWith(MockitoExtension.class)
public class RegisterUserCommandHandlerTest {

    @Mock
    private UserService userService;

    @Mock
    private UserValidator userValidator;

    @Mock
    private UserRepositoryImpl userRepository;

    @InjectMocks
    private RegisterUserCommandHandler handler;

    private UserRegistrationDTO registrationDTO;
    private RegisterUserCommand command;
    private User user;
    /**
     * Sets up the test data before each test method.
     */
    @BeforeEach
    void setUp() {
        registrationDTO = new UserRegistrationDTO();
        registrationDTO.setUsername("testUser");
        registrationDTO.setEmail("test@example.com");
        registrationDTO.setPassword("password");
        registrationDTO.setFirstName("Test");
        registrationDTO.setLastName("User");

        command = new RegisterUserCommand(registrationDTO);

        user = new User();
        user.setUsername(registrationDTO.getUsername());
        user.setEmail(registrationDTO.getEmail());
        user.setPassword(registrationDTO.getPassword());
        user.setFirstName(registrationDTO.getFirstName());
        user.setLastName(registrationDTO.getLastName());
    }
    /**
     * Tests the handle() method with valid user data.
     * It verifies that the userValidator and userService are called as expected.
     */
    @Test
    void testHandle_ValidUser() {
        // Mock the behavior of the dependencies
        when(userValidator.isValid(any(User.class))).thenReturn(true);
        when(userService.registerUser(any(User.class))).thenReturn(user);
        // Execute the handle() method
        handler.handle(command);

        verify(userValidator).isValid(any(User.class));
        verify(userService).registerUser(any(User.class));

    }

    @Test
    void testHandle_InvalidUser() {
        when(userValidator.isValid(any(User.class))).thenReturn(false);

        try {
            handler.handle(command);
        } catch (RuntimeException e) {

        }
        // Verify that the dependencies were called as expected
        verify(userValidator).isValid(any(User.class));
        verify(userService, never()).registerUser(any(User.class));

    }
}