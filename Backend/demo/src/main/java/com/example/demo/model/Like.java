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
public class Like {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long likeId;
  private LikeType likeType;
  @NotNull
  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "postId", referencedColumnName = "postId")
  private Post post;
  @ManyToOne(fetch = LAZY)
  @JoinColumn(name = "userId", referencedColumnName = "userId")
  private User user;
}
