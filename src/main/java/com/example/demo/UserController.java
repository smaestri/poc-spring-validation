package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "/users")
    public ResponseEntity addUSer(@Valid @RequestBody User user, HttpServletResponse response) {

        user.setEmail(user.getEmail());
        user.setLastName(StringUtils.capitalize(user.getLastName()));
        user.setFirstName(StringUtils.capitalize(user.getFirstName()));
        userRepository.save(user);

        return new ResponseEntity(user, HttpStatus.CREATED);
    }

}
