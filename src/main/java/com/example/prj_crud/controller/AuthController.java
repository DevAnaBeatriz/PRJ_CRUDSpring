package com.example.prj_crud.controller;

import com.example.prj_crud.dto.LoginDTO;
import com.example.prj_crud.dto.RegisterDTO;
import com.example.prj_crud.dto.UserDTO;
import com.example.prj_crud.service.AuthService;
import com.example.prj_crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterDTO dto) {
        return authService.register(dto);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO dto) {
        return authService.login(dto);
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getById(id);
    }
}

