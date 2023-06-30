package com.example.demo.service;


import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    User Save(User n);
    User findByUsername(String username);
    User findOne(Long a);
    User createUser(UserDTO userDTO);

    List<User> findAll();
    void ChangePassword(String username,String password);
}
