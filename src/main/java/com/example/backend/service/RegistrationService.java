package com.example.backend.service;

import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private UserRepository userRepository;

    public String register(String username, String password) {
        if (userRepository.findByUsername(username).isPresent()) {
            return "Username already exists!";
        }

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(new BCryptPasswordEncoder().encode(password));
        userRepository.save(newUser);
        return "User registered successfully!";
    }
}