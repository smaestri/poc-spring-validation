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
    public ResponseEntity addUSer(@Valid @RequestBody UserDto userDto, HttpServletResponse response) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setLastName(StringUtils.capitalize(userDto.getLastName()));
        user.setFirstName(StringUtils.capitalize(userDto.getFirstName()));
        userRepository.save(user);

        return new ResponseEntity(user, HttpStatus.CREATED);
    }

}
