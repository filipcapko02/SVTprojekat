package com.example.demo.repository;
import com.example.demo.model.Korisnik;
import com.example.demo.model.Lajk;
import com.example.demo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LajkInterface extends JpaRepository<Lajk, Long> {
  Optional<Lajk> findTopByPostAndKorisnikOrderByLajkIdDesc(Post post, Korisnik trenutniKorisnik);
}

