package com.example.prj_crud.dto;

import com.example.prj_crud.entity.User;

public class UserDTO {

    private String name;
    private String email;
    private String phone;

    public UserDTO() {}

    public UserDTO(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}
