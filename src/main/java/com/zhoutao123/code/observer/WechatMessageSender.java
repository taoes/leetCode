package com.zhoutao123.code.observer;

import java.util.HashSet;
import java.util.Set;

public class WechatMessageSender implements Observerable {

  private final Set<Observer> observers = new HashSet<>();

  public void send(String message) {
    System.out.println("发送消息:" + message);
    notifyObserver();
  }

  @Override
  public void registerObserver(Observer o) {
    observers.add(o);
  }

  @Override
  public void removeObserver(Observer o) {
    observers.remove(o);
  }

  @Override
  public void notifyObserver() {
    for (Observer observer : observers) {
      observer.update("123");
    }
  }
}
