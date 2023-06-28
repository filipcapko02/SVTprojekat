package com.example.demo.repository;

import com.example.demo.model.Grupa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GrupaInterface extends JpaRepository<Grupa, Long> {

  Optional<Grupa> findByIme(String grupaIme);
}
