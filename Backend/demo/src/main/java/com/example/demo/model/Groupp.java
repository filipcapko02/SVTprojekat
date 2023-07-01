package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
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
