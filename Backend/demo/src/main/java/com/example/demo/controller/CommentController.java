package com.example.demo.controller;

import com.example.demo.dto.LikeDTO;
import com.example.demo.model.LikeType;
import com.example.demo.model.Likee;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.security.TokenUtils;
import com.example.demo.service.UserService;
import com.example.demo.service.serviceImpl.CommentService;
import com.example.demo.service.serviceImpl.LikeService;

import com.example.demo.service.serviceImpl.PostServiceImpl;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.annotation.Validated;


import java.security.Principal;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/comment")
@CrossOrigin
public class CommentController {
    @Autowired
    CommentService commentService;
    @Autowired
    PostServiceImpl postServiceimpl;
    @Autowired
    LikeService likeService;

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


    @PostMapping("/addLike")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public HttpStatus korisnik1(Principal user, @RequestBody @Validated LikeDTO dto){
        User korisnik = this.userService.findByUsername(user.getName());
        Post post = this.postServiceimpl.getOne(dto.getId());
        Likee like = new Likee();
        like.setPost(post.getId());
        like.setUser(korisnik.getId());
        like.setDate(LocalDate.now());

        if(dto.getType()==1){
            like.setType(LikeType.LIKE);
        }
        if(dto.getType()==2){
            like.setType(LikeType.DISLIKE);
        }
        likeService.save(like);
        post.getLikes().add(like);
        postServiceimpl.save(post);
        return HttpStatus.CREATED;
    }
}
