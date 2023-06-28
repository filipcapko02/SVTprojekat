package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Lajk {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long lajkId;
  private LajkType lajkType;
  @NotNull
  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "postId", referencedColumnName = "postId")
  private Post post;
  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "korisnikId", referencedColumnName = "korisnikId")
  private Korisnik korisnik;
}
