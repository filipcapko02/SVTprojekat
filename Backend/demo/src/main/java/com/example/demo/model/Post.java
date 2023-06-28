package com.example.demo.model;

import java.time.Instant;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long postId;
  private String postIme;
  private String url;
  @Lob
  private String opis;
  private Integer voteCount = 0;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "korisnikId", referencedColumnName = "korisnikId")
  private Korisnik korisnik;
  private Instant createdDate;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id", referencedColumnName = "id")
  private Grupa grupa;
}
