package com.java.design.pattern.singleton;

import java.io.Serializable;

public class ClassicSingleton
    implements Serializable {

  private static ClassicSingleton INSTANCE = null;

  private ClassicSingleton() {
  }

  public static ClassicSingleton getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new ClassicSingleton();
    }
    return INSTANCE;
  }

  /*
    Resolves an object after serialization
    This ensure that the same instance is returned even after this class is de-serialized
   */
  public Object readResolve() {
    return INSTANCE;
  }

  /*
    Writes an object during serialization
    This ensure that the same instance serialized
   */
  public Object writeReplace() {
    return INSTANCE;
  }

  /*
    Singleton class should not support cloning
   */
  @Override
  public Object clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException("Singleton class cannot be cloned");
  }

}
