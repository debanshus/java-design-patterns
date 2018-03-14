package com.java.design.pattern.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SingletonClient {

  public static void main(String[] args) {

    //Both time sysout will print the same hashcode
    System.out.println(BasicSingleton
                           .getInstance()
                           .hashCode());

    System.out.println(BasicSingleton
                           .getInstance()
                           .hashCode());

    //Singleton cannot be cloned
    try {
      ClassicSingleton
          .getInstance()
          .clone();
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }

    //Same hashcode returned even after serializing and de-serializing
    ClassicSingleton classicSingleton = ClassicSingleton.getInstance();
    System.out.println("Before serializing: " + classicSingleton.hashCode());

    try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("serialized.txt"))) {
      stream.writeObject(classicSingleton);
    } catch (IOException ex) {
      //no-op
    }

    try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream("serialized.txt"))) {
      ClassicSingleton classicSingletonRecovered = (ClassicSingleton) stream.readObject();
    } catch (ClassNotFoundException | IOException ex) {
      //no-op
    }

    System.out.println("After serializing: " + classicSingleton.hashCode());

  }
}
