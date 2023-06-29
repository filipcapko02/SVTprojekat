package com.example.demo.repository;
import com.example.demo.model.User;
import com.example.demo.model.Like;
import com.example.demo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeInterface extends JpaRepository<Like, Long> {
  Optional<Like> findTopByPostAndUserOrderByLikeIdDesc(Post post, User currentUser);
}

