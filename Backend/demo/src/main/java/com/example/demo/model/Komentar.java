package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Komentar {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String text;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "postId", referencedColumnName = "postId")
  private Post post;
  private Instant createdDate;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "korisnikId", referencedColumnName = "korisnikId")
  private Korisnik korisnik;
}
