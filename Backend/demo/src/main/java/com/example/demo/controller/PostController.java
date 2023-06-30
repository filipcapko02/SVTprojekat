package com.example.demo.controller;
import com.example.demo.dto.PostDTO;
import com.example.demo.dto.PostGroupDTO;
import com.example.demo.dto.PostSaveDTO;
import com.example.demo.model.Groupp;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.security.TokenUtils;
import com.example.demo.service.UserService;
import com.example.demo.serviceImpl.GroupServiceImpl;
import com.example.demo.serviceImpl.PostServiceimpl;
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
@RequestMapping("api/post")
public class PostController  {

    @Autowired
    PostServiceimpl postService;
    @Autowired
    UserService userService;
    @Autowired
    GroupServiceImpl groupService;
    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TokenUtils tokenUtils;
    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/create")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public Post user(Principal user, @RequestBody @Validated PostDTO dto) {

        User nesto = this.userService.findByUsername(user.getName());

        Post b = this.postService.createGroup(dto.getText(),nesto.getId());
        nesto.getPosts().add(b);
        userService.Save(nesto);
        return b;
    }
    @DeleteMapping("/delete")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public HttpStatus user1(Principal user, @RequestBody @Validated  Long id) {
        // Long id = Long.valueOf(idd);
        User nesto = this.userService.findByUsername(user.getName());

        if( this.postService.getOne(id).getUser() == nesto.getId())
        {
            this.postService.delete(id);
            return HttpStatus.ACCEPTED;
        }
        else return HttpStatus.NOT_ACCEPTABLE;
    }
    @GetMapping("/All")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public List<PostDTO> user(Principal user) {

        User pera = this.userService.findByUsername(user.getName());
        return postService.getAll(pera.getId());

    }
    @GetMapping("/AllAll")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public List<PostDTO> use1r(Principal user) {


        return postService.getAllAll();

    }
    @PostMapping("/GroupPost")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public Post useaar(Principal user, @RequestBody @Validated PostGroupDTO dto) {
        User peraa = this.userService.findByUsername(user.getName());
        Groupp pera = this.groupService.getOne(Long.valueOf(dto.getGroup()));

        Post b = this.postService.createGroup(dto.getText(),peraa.getId());
        pera.getPosts().add(b);
        groupService.save(pera);
        return b;
    }

    @PostMapping("/save")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public HttpStatus userf(Principal user, @RequestBody @Validated PostSaveDTO dto ) {

        User nesto = this.userService.findByUsername(user.getName());
        Post nestoo = postService.getOne(dto.getId());
        if(nestoo.getUser() == nesto.getId())
        {
            nestoo.setText(dto.getText());
            postService.save(nestoo);
            return HttpStatus.ACCEPTED;
        }
        return HttpStatus.NOT_ACCEPTABLE;
    }

    @PostMapping("/one")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public Post userf(Principal user, @RequestBody @Validated Long id ) {

        User nesto = this.userService.findByUsername(user.getName());
        Post nestoo = postService.getOne(id);
        if( nestoo.getUser() == nesto.getId())
        {

            return this.postService.getOne(id);
        }
        else return null;
    }
}