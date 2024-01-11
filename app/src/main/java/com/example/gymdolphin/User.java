package com.example.gymdolphin;

import java.util.Calendar;
import java.util.Random;

public class User {
    private String firstName;
    private String lastName;
    private String birthday;
    private String email;
    private String password;
    private String username;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String firstName, String lastName, String birthday, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
        this.username = generateUsername();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    private String generateUsername() {
        // Combine first and last name with a random number between 1 and 99
        Random random = new Random();
        int randomNumber = random.nextInt(99) + 1;
        return firstName.toLowerCase() + lastName.toLowerCase() + randomNumber;
    }
}
