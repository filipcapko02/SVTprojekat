package com.example.demo.service.serviceImpl;
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

    public Comment GetOne(Long id) {

        return   this.commentInterface.findFirstById(id);


    }
    public Comment GetAllByComment(Long id) {

        return   this.commentInterface.findFirstById(id);


    }
    public void save(Comment dt) {
        this.commentInterface.save(dt);
    }
}
