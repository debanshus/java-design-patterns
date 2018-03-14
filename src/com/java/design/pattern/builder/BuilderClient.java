package com.java.design.pattern.builder;

import com.java.design.pattern.builder.Student.Builder;

public class BuilderClient {

  public static void main(String[] args) {

    Student student1 = new Builder("max johnson", 21)
        .marks(90)
        .monitor(true)
        .section("A")
        .build();

    System.out.println(student1);

    Student student2 = new Builder("max johnson", 21)
        .marks(90)
        .build();

    System.out.println(student2);
  }

}
