package com.example.backend.controller;

import com.example.backend.dto.RegistrationRequest;
import com.example.backend.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/register")
    public String register(@RequestBody RegistrationRequest registrationRequest) {
        return registrationService.register(registrationRequest.getUsername(), registrationRequest.getPassword());
    }

    @GetMapping("/hello")
    public String helloFromEC2() {
        return "Hello from EC2";
    }
}