package com.offer.huawei;

/**
 * MainTest class
 *
 * @author 格林
 * @date 2023-08-01
 */
public class MainTest {
    public static void main(String[] args) {

       while (true) {
           new Thread( () -> {
               testA();
           }).start();

          new Thread(() ->{
              testB();
          }).start();
       }
    }

    public static void testA() {
        try {
            for(int i = 0; i < 10; i ++) {
                Thread.sleep(1000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void testB() {
        try {
            for(int i = 0; i < 10; i ++) {
                Thread.sleep(10000);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
