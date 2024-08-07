package com.example.AuthenticatedBackend.controllers;

import com.example.AuthenticatedBackend.DTO.LoginResponseDTO;
import com.example.AuthenticatedBackend.DTO.RegistrationDTO;
import com.example.AuthenticatedBackend.models.User;
import com.example.AuthenticatedBackend.services.AuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticateController {
    @Autowired
    private AuthenticateService authenticationService;

    @PostMapping("/register")
    public User registerUser(@RequestBody RegistrationDTO DTO){
        return authenticationService.registerUser(DTO.getUsername(), DTO.getPassword());

    }

    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO DTO){
        return authenticationService.loginUser(DTO.getUsername(), DTO.getPassword());
    }
}
