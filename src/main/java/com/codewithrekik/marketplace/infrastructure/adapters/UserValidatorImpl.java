package com.codewithrekik.marketplace.infrastructure.adapters;

import com.codewithrekik.marketplace.domain.entities.User;
import com.codewithrekik.marketplace.domain.interfaces.UserValidator;
import org.springframework.stereotype.Component;

@Component
public class UserValidatorImpl implements UserValidator {
    @Override
    public boolean isValid(User user) {

        return user.getUsername() != null && user.getEmail() != null && user.getPassword() != null;
    }
}