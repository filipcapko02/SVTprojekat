package com.example.demo.serviceImpl;
import com.example.demo.model.Comment;
import com.example.demo.repository.CommentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service

@Primary
public class CommentService {
    @Autowired
    private CommentInterface commentInterface;

    public Optional<Comment> GetOneById(Long id) {

        return  this.commentInterface.findById(id);


    }
    public void save(Comment dt) {
        this.commentInterface.save(dt);
    }
}