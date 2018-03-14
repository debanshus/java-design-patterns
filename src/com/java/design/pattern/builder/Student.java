package com.java.design.pattern.builder;

public class Student {

  private String name;
  private int age;
  private boolean isMonitor;
  private String section;
  private double marks;

  public Student(Builder builder) {
    this.name = builder.name;
    this.age = builder.age;
    this.isMonitor = builder.isMonitor;
    this.section = builder.section;
    this.marks = builder.marks;
  }

  @Override
  public String toString() {
    return "Student{" +
           "name='" + name + '\'' +
           ", age=" + age +
           ", isMonitor=" + isMonitor +
           ", section='" + section + '\'' +
           ", marks=" + marks +
           '}';
  }

  //This could have been an independent class as well
  public static class Builder {

    //mandatory fields, so them should be passed with the constructor
    private String name;
    private int age;

    //non-mandatory fields, use setter methods
    private boolean isMonitor;
    private String section;
    private double marks;

    public Builder(String name, int age) {
      this.name = name;
      this.age = age;
    }

    public Builder monitor(boolean monitor) {
      this.isMonitor = monitor;
      return this;
    }

    public Builder section(String section) {
      this.section = section;
      return this;
    }

    public Builder marks(double marks) {
      this.marks = marks;
      return this;
    }

    public Student build() {
      return new Student(this);
    }

  }

}
