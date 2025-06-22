package com.example.prj_crud.service;

import com.example.prj_crud.dto.UserDTO;
import com.example.prj_crud.entity.User;
import com.example.prj_crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserDTO> getAll() {
        return repository.findAll().stream().map(this::toDTO).toList();
    }

    public UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        return dto;
    }

    public UserDTO getById(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return new UserDTO(user);
    }

    public UserDTO update(Long id, UserDTO dto) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());

        return toDTO(repository.save(user));
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado");
        }
        repository.deleteById(id);
    }

}
