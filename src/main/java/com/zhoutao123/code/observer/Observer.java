package com.zhoutao123.code.observer;

public abstract class Observer {

  public void update(String message) {
    System.out.println(message);
  }
  ;
}
