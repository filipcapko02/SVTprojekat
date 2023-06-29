package com.example.demo.model;

public enum LikeType {
  LIKE(1), DISLIKE(-1),
  ;
  private int direction;

  LikeType(int direction) {
  }
}
