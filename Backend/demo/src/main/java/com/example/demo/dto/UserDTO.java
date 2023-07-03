package com.example.demo.dto;

import com.example.demo.model.Roles;
import com.example.demo.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {


    private Long id;

    private String username;


    private String password;

    private String email;


    private String firstname;

    private String lastname;

    public UserDTO(User createdUser) {
        this.id = createdUser.getId();
        this.username = createdUser.getUsername();
        this.firstname = createdUser.getFirstname();
        this.lastname = createdUser.getLastname();
        this.email = createdUser.getEmail();
    }






}
