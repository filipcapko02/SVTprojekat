package com.example.demo.repository;

import com.example.demo.model.Grupa;
import com.example.demo.model.Korisnik;
import com.example.demo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface PostInterface extends JpaRepository<Post, Long> {
  List<Post> findAllByGrupa(Grupa grupa);

  List<Post> findByKorisnik(Korisnik korisnik);
}
