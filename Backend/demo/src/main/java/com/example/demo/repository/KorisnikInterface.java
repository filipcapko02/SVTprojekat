package com.example.demo.repository;

import com.example.demo.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface KorisnikInterface extends JpaRepository<Korisnik, Long> {
  Optional<Korisnik> findByUsername(String username);
}
