package com.example.demo.serviceImpl;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import com.example.demo.repository.UserInterface;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserInterface userInterface;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User findByUsername(String username) {
        Optional<User> user = userInterface.findByUsername(username);
        if (!user.isEmpty()) {
            return user.get();
        }
        return null;
    }
    @Override
    public void ChangePassword(String username,String password) {
        Optional<User> user = userInterface.findByUsername(username);

        User nesto=  user.get();
        nesto.setPassword(passwordEncoder.encode(password));
        userInterface.save(nesto);


    }

    @Override
    public User createUser(UserDTO userDTO) {

        Optional<User> user = userInterface.findByUsername(userDTO.getUsername());

        if(user.isPresent()){
            return null;
        }

        User newUser = new User();
        newUser.setUsername(userDTO.getUsername());
        newUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        newUser.setEmail(userDTO.getEmail());
        newUser = userInterface.save(newUser);


        return newUser;
    }

    @Override
    public List<User> findAll() {
        return this.userInterface.findAll();
    }
    @Override
    public User findOne(Long a) {
        return this.userInterface.findFirstById(a);
    }
    @Override
    public User Save(User n) {
        return this.userInterface.save(n);
    }
}
