package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


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
