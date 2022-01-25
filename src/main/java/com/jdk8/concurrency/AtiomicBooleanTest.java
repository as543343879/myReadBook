package com.jdk8.concurrency;

import org.junit.Test;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * AtiomicBooleanTest class
 *
 * @author 谢小平
 * @date 2022/1/11
 */
public class AtiomicBooleanTest {
    static  AtomicBoolean atomicBoolean = new AtomicBoolean(false);
    @Test
    public void test1() {
        boolean andSet = atomicBoolean.getAndSet(true);
        System.out.println(andSet);
        boolean compareAndSet = atomicBoolean.compareAndSet(false, true);
        System.out.println(compareAndSet + "--" + atomicBoolean.get());

         compareAndSet = atomicBoolean.compareAndSet(true, false);
        System.out.println(compareAndSet +  "--" + atomicBoolean.get());



    }
}
