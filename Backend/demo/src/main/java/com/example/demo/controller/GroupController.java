package com.example.demo.controller;
import com.example.demo.dto.GroupDTO;
import com.example.demo.dto.GroupReciveDTO;
import com.example.demo.model.Groupp;
import com.example.demo.model.User;
import com.example.demo.security.TokenUtils;
import com.example.demo.service.UserService;
import com.example.demo.serviceImpl.GroupServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("api/group")
public class GroupController  {

    @Autowired
    GroupServiceImpl groupService;
    @Autowired
    UserService userService;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TokenUtils tokenUtils;
    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/getAll")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public List<Groupp> user1(Principal user) {
        return this.groupService.findAll();
    }
    @DeleteMapping("/delete")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public HttpStatus user1(Principal user, @RequestBody @Validated  Long id) {
        User nesto = this.userService.findByUsername(user.getName());

        if( this.groupService.getOne(id).getGroupAdmin() == nesto.getId())
        {
            this.groupService.delete(id);
            return HttpStatus.ACCEPTED;
        }
        else return HttpStatus.NOT_ACCEPTABLE;
    }
    @PostMapping("/one")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public Groupp usesr1(Principal user, @RequestBody @Validated  Long id) {
        User pera = this.userService.findByUsername(user.getName());

        if( this.groupService.getOne(id).getGroupAdmin() == pera.getId())
        {
            return groupService.getOne(id);

        }
        else return null;
    }
    @PostMapping("/save")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public Groupp usesr1(Principal user, @RequestBody @Validated GroupReciveDTO dto) {
        User nesto = this.userService.findByUsername(user.getName());

        if( this.groupService.getOne(dto.getId()).getGroupAdmin() == nesto.getId())
        {
            Groupp nestoo =  groupService.getOne(dto.getId());
            nestoo.setName(dto.getName());
            nestoo.setDescription(dto.getDescription());
            groupService.save(nestoo);

        }
        else return null;
        return null;
    }
    @PostMapping("/create")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public Groupp user(Principal user,@RequestBody @Validated GroupDTO dto) {

        User nesto = this.userService.findByUsername(user.getName());
        return this.groupService.createGroup(dto,nesto.getId());
    }





}

