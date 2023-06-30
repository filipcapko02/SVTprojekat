package com.example.demo.model;

import javax.persistence.*;
import lombok.*;
import lombok.Getter;
import lombok.Setter;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "groupp")
public class Groupp {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private String name;
  @Column(nullable = false)
  private String Description;
  @Column(nullable = false)
  private LocalDateTime date;
  @Column(nullable = false)
  private Long GroupAdmin;
  @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
  private Set<Post> posts = new HashSet<Post>();
  @Column(nullable = true)
  private Boolean deleted;
}
