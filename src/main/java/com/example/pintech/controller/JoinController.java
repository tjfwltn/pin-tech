package com.example.pintech.controller;

import com.example.pintech.dto.JoinDTO;
import com.example.pintech.entity.UserEntity;
import com.example.pintech.service.SignupService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JoinController {

    private final SignupService signupService;

    public JoinController(SignupService signupService) {
        this.signupService = signupService;
    }

    @PostMapping("/signup")
    public UserEntity signup(JoinDTO joinDTO) {
        return signupService.signup(joinDTO);
    }
}
