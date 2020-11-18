package com.jdk8;

class ThreadPrintDemo3{

  static volatile int num = 0;
  static volatile boolean flag = false;

  public static void main(String[] args) {

    Thread t1 = new Thread(() -> {
      for (; 100 > num; ) {
        if (!flag && (num == 0 || ++num % 2 == 0)) {

          try {
            Thread.sleep(100);// 防止打印速度过快导致混乱
          } catch (InterruptedException e) {
            //NO
          }

          System.out.println(num);
          flag = true;
        }
      }
    }
    );

    Thread t2 = new Thread(() -> {
      for (; 100 > num; ) {
        if (flag && (++num % 2 != 0)) {

          try {
            Thread.sleep(100);// 防止打印速度过快导致混乱
          } catch (InterruptedException e) {
            //NO
          }

          System.out.println(num);
          flag = false;
        }
      }
    }
    );

    t2.start();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    t1.start();

  }
}