package com.example.demo.repository;

import com.example.demo.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupInterface extends JpaRepository<Group, Long> {

  Optional<Group> findByName(String groupName);
}
