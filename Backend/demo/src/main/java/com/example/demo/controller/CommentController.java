package com.example.demo.controller;

import com.example.demo.dto.LikeDTO;
import com.example.demo.model.LikeType;
import com.example.demo.model.Likee;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.security.TokenUtils;
import com.example.demo.service.UserService;
import com.example.demo.serviceImpl.CommentService;
import com.example.demo.serviceImpl.LikeService;
import com.example.demo.serviceImpl.PostServiceimpl;
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
    PostServiceimpl postServiceimpl;
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
    public HttpStatus user1(Principal user, @RequestBody @Validated LikeDTO dto){
        User user1 = this.userService.findByUsername(user.getName());
        Post p = this.postServiceimpl.getOne(dto.getId());
        Likee r = new Likee();
        r.setPost(p.getId());
        r.setUser(user1.getId());
        r.setDate(LocalDate.now());

        if(dto.getType()==1){
            r.setType(LikeType.LIKE);
        }
        if(dto.getType()==2){
            r.setType(LikeType.DISLIKE);
        }
        likeService.save(r);
        p.getLikes().add(r);
        postServiceimpl.save(p);
        return HttpStatus.CREATED;
    }
}
