package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class EmailValidator implements
        ConstraintValidator<EmailExisting, String> {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean isValid(String email,
                           ConstraintValidatorContext cxt) {
        List<User> users = userRepository.findByEmail(email);
        if (!users.isEmpty()) {
            return false;
        }
        return true;
    }

}