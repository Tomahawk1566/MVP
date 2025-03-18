package com.example.familyplanner.service;

import com.example.familyplanner.dto.RegistrationRequest;
import com.example.familyplanner.entity.User;
import com.example.familyplanner.service.RegisterUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public  class UserController {

    private final RegisterUserService registerUserService;

    public UserController(RegisterUserService registerUserService) {
        this.registerUserService = registerUserService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody RegistrationRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // Password will be encoded in service
        registerUserService.registerUser(user);
        return ResponseEntity.ok(user);
    }
}
