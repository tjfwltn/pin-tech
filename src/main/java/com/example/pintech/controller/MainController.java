package com.example.pintech.controller;

import com.example.pintech.dto.AuthRequest;
import com.example.pintech.dto.AuthResponse;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
        return new AuthResponse(authRequest.getUsername(), authRequest.getPassword());
    }

    @GetMapping("/user/{id}")
    public long getUser(@PathVariable Long id) {
        return id;
    }
}
