package com.jdk8.concurrency;

import java.util.concurrent.Executors;

public class ThreadUtils {
    public static void sleep(long millis) {
        try {


            Thread.sleep(millis);
        } catch (InterruptedException ignored) {
        }
    }
}