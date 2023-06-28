package com.example.demo.model;

public enum LajkType {
  LAJK(1), DISLAJK(-1),
  ;
  private int direction;

  LajkType(int direction) {
  }
}
