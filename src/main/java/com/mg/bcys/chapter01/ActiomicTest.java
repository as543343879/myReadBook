package com.mg.bcys.chapter01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ActiomicTest class
 *  测试原子增长 cas 跟普通方式
 * @author 谢小平
 * @date 2018/7/26
 */
public class ActiomicTest {
    private int i = 0;
    private AtomicInteger atomicI = new AtomicInteger(0);
    public static void main(String[] args) {
        ActiomicTest actiomicTest = new ActiomicTest();
        List<Thread> ts = new ArrayList<>(600);
        long start = System.currentTimeMillis();
        for(int j = 0; j < 100; j ++ ) {
            Thread t = new Thread(()->{
                for(int i = 0; i < 10000; i ++) {
                    actiomicTest.count();
                    actiomicTest.safeCount();
                }
            });

            ts.add(t);
        }
        for(Thread thread : ts) {
            thread.start();
        }
        for(Thread t : ts) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(actiomicTest.i);
        System.out.println(actiomicTest.atomicI.get());
        System.out.println(System.currentTimeMillis() - start);

    }

    private void count() {
        i ++;
    }
    private  void safeCount () {
        for(;;) {
            int i = atomicI.get();
            boolean suc = atomicI.compareAndSet(i, ++i);
            if(suc) {
                break;
            }
        }
    }
}
