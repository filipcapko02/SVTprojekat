package com.example.demo.repository;
import com.example.demo.model.Komentar;
import com.example.demo.model.Korisnik;
import com.example.demo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KomentarInterface extends JpaRepository<Komentar, Long> {
  List<Komentar> findByPost(Post post);

  List<Komentar> findAllByKorisnik(Korisnik korisnik);
}
