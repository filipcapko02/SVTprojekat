package com.example.demo.controller;
import com.example.demo.dto.PostDTO;
import com.example.demo.dto.PostGroupDTO;
import com.example.demo.dto.PostSaveDTO;
import com.example.demo.model.Groupp;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.security.TokenUtils;
import com.example.demo.service.UserService;
import com.example.demo.service.serviceImpl.GroupServiceImpl;
import com.example.demo.service.serviceImpl.PostServiceImpl;
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
    PostServiceImpl postService;
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

        User korisnik = this.userService.findByUsername(user.getName());

        Post p = this.postService.createGroup(dto.getText(),korisnik.getId());
        korisnik.getPosts().add(p);
        userService.Save(korisnik);
        return p;
    }
    @DeleteMapping("/delete")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public HttpStatus korisnik1(Principal user, @RequestBody @Validated  Long id) {

        User korisnik = this.userService.findByUsername(user.getName());

        if( this.postService.getOne(id).getUser() == korisnik.getId())
        {
            this.postService.delete(id);
            return HttpStatus.ACCEPTED;
        }
        else return HttpStatus.NOT_ACCEPTABLE;
    }
    @GetMapping("/All")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public List<PostDTO> user(Principal user) {

        User korisnik = this.userService.findByUsername(user.getName());
        return postService.getAll(korisnik.getId());

    }
    @GetMapping("/Sve")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public List<PostDTO> korisnik2(Principal user) {


        return postService.getSve();

    }
    @PostMapping("/GroupPost")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public Post korisnik3(Principal user, @RequestBody @Validated PostGroupDTO dto) {
        User kor = this.userService.findByUsername(user.getName());
        Groupp grupa = this.groupService.getOne(Long.valueOf(dto.getGroup()));

        Post b = this.postService.createGroup(dto.getText(),kor.getId());
        grupa.getPosts().add(b);
        groupService.save(grupa);
        return b;
    }

    @PostMapping("/save")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public HttpStatus korisnik4(Principal user, @RequestBody @Validated PostSaveDTO dto ) {

        User kor = this.userService.findByUsername(user.getName());
        Post post = postService.getOne(dto.getId());
        if(post.getUser() == kor.getId())
        {
            post.setText(dto.getText());
            postService.save(post);
            return HttpStatus.ACCEPTED;
        }
        return HttpStatus.NOT_ACCEPTABLE;
    }

    @PostMapping("/one")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public Post korisnik6(Principal user, @RequestBody @Validated Long id ) {

        User korisnik = this.userService.findByUsername(user.getName());
        Post post = postService.getOne(id);
        if( post.getUser() == korisnik.getId())
        {

            return this.postService.getOne(id);
        }
        else return null;
    }
}