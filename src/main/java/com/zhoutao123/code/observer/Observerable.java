package com.zhoutao123.code.observer;

public interface Observerable {
  public void registerObserver(Observer o);

  public void removeObserver(Observer o);

  public void notifyObserver();
}
