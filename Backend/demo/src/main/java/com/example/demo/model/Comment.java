package com.example.demo.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Comment")
public class Comment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false,unique = true)
  private Long user;

  @Column(nullable = false)
  private String text;

  @Column(nullable = false)
  private LocalDate date;
  @Column(nullable = false)
  private Boolean deleted;
  @OneToMany( fetch = FetchType.LAZY)
  private Set<Likee> Reaction= new HashSet<Likee>();
}
