package com.example.backend.controller;

import com.example.backend.dto.RegistrationRequest;
import com.example.backend.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody RegistrationRequest registrationRequest) {
        String responseMessage;
        Map<String, String> response = new HashMap<>();

        try {
            responseMessage = registrationService.register(registrationRequest.getUsername(), registrationRequest.getPassword());
            response.put("message", responseMessage);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("error", "Registration failed: " + e.getMessage());
            return ResponseEntity.status(400).body(response);
        }
    }

    @GetMapping("/hello")
    public ResponseEntity<Map<String, String>> helloFromEC2() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello from EC2");
        return ResponseEntity.ok(response);
    }
}