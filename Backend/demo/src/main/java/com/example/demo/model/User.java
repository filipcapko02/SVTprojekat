package com.example.demo.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import java.time.Instant;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String username;

  @Column(nullable = false)
  private String password;
  @Column()
  private String displayName;
  @Column()
  private String description;

  @Column(nullable = false, unique = true)
  private String email;
  @Column(nullable = false)
  private LocalDateTime LastLogin;
  @Column(nullable = false)
  private String firstname;
  @Column(nullable = false)
  private String lastname;
  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private Roles role;
  @OneToMany( fetch = FetchType.EAGER ,cascade = CascadeType.REMOVE)
  private Set<Post> posts = new HashSet<Post>();
}
