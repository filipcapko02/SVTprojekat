package com.example.demo.repository;
import com.example.demo.model.Comment;
import com.example.demo.model.User;
import com.example.demo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentInterface extends JpaRepository<Comment, Long> {
    Comment findFirstById(long id);
}
