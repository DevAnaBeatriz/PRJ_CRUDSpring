package com.example.prj_crud.service;

import com.example.prj_crud.dto.LoginDTO;
import com.example.prj_crud.dto.RegisterDTO;
import com.example.prj_crud.entity.User;
import com.example.prj_crud.repository.UserRepository;
import com.example.prj_crud.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtUtil jwtUtil;

    public String register(RegisterDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setUsername(dto.getUsername());
        user.setPassword(encoder.encode(dto.getPassword()));
        repository.save(user);
        return "Usuário registrado com sucesso!";
    }

    public String login(LoginDTO dto) {
        System.out.println("Tentando logar com: " + dto.getUsername());

        User user = repository.findByUsername(dto.getUsername())
                .orElseThrow(() -> {
                    System.out.println("Usuário não encontrado");
                    return new RuntimeException("Usuário não encontrado");
                });

        System.out.println("Usuário encontrado: " + user.getUsername());

        if (!encoder.matches(dto.getPassword(), user.getPassword())) {
            System.out.println("Senha incorreta");
            throw new RuntimeException("Senha incorreta");
        }

        System.out.println("Senha válida! Gerando token...");

        return jwtUtil.generateToken(user.getUsername());
    }

}

