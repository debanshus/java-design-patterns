package com.java.design.pattern.singleton;

public class BasicSingleton {

  private static BasicSingleton INSTANCE = null;

  private BasicSingleton() {
  }

  public static BasicSingleton getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new BasicSingleton();
    }
    return INSTANCE;
  }

}
