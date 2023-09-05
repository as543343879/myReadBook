package com.jdk8.base;

import java.lang.reflect.Method;

interface Parent {
   public void method();
}

class Child implements Parent {
   @Override
   public void method() {
      System.out.println("Child class");
   }
}

public class Main {
   public static void main(String[] args) throws Exception {
      Child obj = new Child();
      Method method = obj.getClass().getMethod("method");

      obj.getClass().getDeclaredMethod("method");
      Class<?>[] interfaces = Child.class.getInterfaces();

      if (method.isAnnotationPresent(Override.class)) {
         System.out.println("method is overriden");
      } else {
         System.out.println("method is not overriden");
      }
   }
}