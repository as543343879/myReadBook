package com.jdk8.agent;

public class MyAgent {
  public static void premain(String args) {
    System.out.println("premain");
  }
}