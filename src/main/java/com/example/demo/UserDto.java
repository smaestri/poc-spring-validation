package com.example.demo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserDto {

    private int id;

    @EmailExisting
    private String email;

    @NotBlank
    @Size(min = 2, max = 25, message = "Le prénom doit faire entre 5 et 25 caractères")
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 25, message = "Le nom doit faire entre 5 et 25 caractères")
    private String lastName;

    @NotBlank
    @Size(min = 6, message = "Le mot de pase doit faire au moins 6 caractères")
    private String password;

    public UserDto() {
    }

    public UserDto(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


