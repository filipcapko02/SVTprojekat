package com.example.demo.service;
import com.example.demo.dto.CommentsDto;
import com.example.demo.exceptions.PostNotFoundException;
import com.example.demo.exceptions.SpringDemoException;
import com.example.demo.mapper.CommentMapper;
import com.example.demo.model.Comment;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.repository.CommentInterface;
import com.example.demo.repository.PostInterface;
import com.example.demo.repository.UserInterface;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentService {
    private static final String POST_URL = "";
    private final PostInterface postInterface;
    private final UserInterface userInterface;
    private final AuthService authService;
    private final CommentMapper commentMapper;
    private final CommentInterface commentInterface;


    public void save(CommentsDto commentsDto) {
        Post post = postInterface.findById(commentsDto.getPostId())
                .orElseThrow(() -> new PostNotFoundException(commentsDto.getPostId().toString()));
        Comment comment = commentMapper.map(commentsDto, post, authService.getCurrentUser());
        commentInterface.save(comment);

    }

    public List<CommentsDto> getAllCommentsForPost(Long postId) {
        Post post = postInterface.findById(postId).orElseThrow(() -> new PostNotFoundException(postId.toString()));
        return commentInterface.findByPost(post)
                .stream()
                .map(commentMapper::mapToDto).toList();
    }

    public List<CommentsDto> getAllCommentsForUser(String userName) {
        User user = userInterface.findByUsername(userName)
                .orElseThrow(() -> new UsernameNotFoundException(userName));
        return commentInterface.findAllByUser(user)
                .stream()
                .map(commentMapper::mapToDto)
                .toList();
    }

    public boolean containsSwearWords(String comment) {
        if (comment.contains("lose")) {
            throw new SpringDemoException("Comments contains unacceptable language");
        }
        return false;
    }
}