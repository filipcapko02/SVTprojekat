package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.Getter;
import lombok.Setter;
import java.time.Instant;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Grupa {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;
  private String ime;
  private String opis;
  @OneToMany(fetch = LAZY)
  private List<Post> postovi;
  private Instant createdDate;
  @ManyToOne(fetch = LAZY)
  private Korisnik korisnik;
}
