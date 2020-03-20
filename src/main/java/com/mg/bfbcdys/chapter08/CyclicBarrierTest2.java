package com.mg.bfbcdys.chapter08;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrierTest2 class
 *
 * @author 谢小平
 * @date 2019/9/17
 */
public class CyclicBarrierTest2 {
    static CyclicBarrier c = new CyclicBarrier(2,()->{
        System.out.println(3);
    });
    public static void main(String[] args) {
           new Thread(()->{
               try {
                   c.await();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               } catch (BrokenBarrierException e) {
                   e.printStackTrace();
               }
               System.out.println(1);
           }).start();
        try {
            c.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }
}
