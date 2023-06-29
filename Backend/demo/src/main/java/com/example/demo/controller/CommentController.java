package com.example.demo.controller;

import com.example.demo.dto.CommentsDAO;
import com.example.demo.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/comments")
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;
    

    @PostMapping
    public ResponseEntity<Void> createComment(@RequestBody CommentsDAO commentsDAO) {
        commentService.save(commentsDAO);
        return new ResponseEntity<>(CREATED);
    }

    @GetMapping(params = "postId")
    public ResponseEntity<List<CommentsDAO>> getAllCommentsForPost(@RequestParam Long postId) {
        return ResponseEntity.status(OK)
                .body(commentService.getAllCommentsForPost(postId));
    }

    @GetMapping(params = "userName")
    public ResponseEntity<List<CommentsDAO>> getAllCommentsForUser(@RequestParam String userName){
        return ResponseEntity.status(OK)
                .body(commentService.getAllCommentsForUser(userName));
    }
}
