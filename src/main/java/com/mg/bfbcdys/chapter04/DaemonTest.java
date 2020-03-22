package com.mg.bfbcdys.chapter04;

/**
 * VolatileTest class
 *
 * @author 谢小平
 * @date 2019/9/6
 */
public class DaemonTest {

    public static void main(String[] args) {
       Thread thread = new Thread(()-> {
           try {
               Thread.sleep(2000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           } finally {
               System.out.println("xxp is god");
           }
       },"xxde thread" );
       thread.setDaemon(true);
       thread.start();
    }

}
