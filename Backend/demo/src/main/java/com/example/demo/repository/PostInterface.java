package com.example.demo.repository;

import com.example.demo.model.Groupp;
import com.example.demo.model.User;
import com.example.demo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface PostInterface extends JpaRepository<Post, Long> {
  List<Post> findAllByGroup(Groupp groupp);

  List<Post> findByUser(User user);

  List<Post> findAllByUserAndDeleted(Long User,boolean Deleted);
  List<Post> findAllByDeleted(boolean Deleted);
  Post findFirstById(Long Id);

}
