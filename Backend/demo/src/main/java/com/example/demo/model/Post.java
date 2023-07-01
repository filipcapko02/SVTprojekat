package com.example.demo.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "post")
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private Long user;

  @Column(nullable = false)
  private String text;
  @Column(nullable = false)
  private LocalDateTime date;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
  private Set<Comment> comments = new HashSet<Comment>();

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
  private Set<Likee> likes = new HashSet<Likee>();
  @Column(nullable = true)
  private Boolean deleted;
}
