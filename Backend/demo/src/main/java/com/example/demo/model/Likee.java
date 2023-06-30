package com.example.demo.model;

import lombok.*;

import javax.persistence.*;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Likee")
public class Likee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private Long user;
  @Column(nullable = false ,unique = true)
  private Long post;

  @Enumerated(EnumType.STRING)
  private LikeType type;
  @Column(nullable = false)
  private LocalDate date;
}
