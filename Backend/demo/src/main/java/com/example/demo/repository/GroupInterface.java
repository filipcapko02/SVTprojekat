package com.example.demo.repository;

import com.example.demo.model.Groupp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupInterface extends JpaRepository<Groupp, Long> {

  Groupp findFirstById(Long Id);
  List<Groupp> findAllByDeleted(Boolean Deleted);
  Optional<Groupp> findFirstByNameAndDeleted(String Name,Boolean Deleted);

}
