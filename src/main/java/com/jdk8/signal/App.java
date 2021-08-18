package com.jdk8.signal;

import sun.misc.Signal;

public class App {
    @SuppressWarnings("restriction")
    public static void main(String[] args) {
        TestSignal handler = new TestSignal();
        Signal.handle(new Signal("TERM"), handler);
        Signal.handle(new Signal("INT"), handler);
        Signal.handle(new Signal("SEGV"), handler);
        Signal.handle(new Signal("ILL"), handler);
//        Signal.handle(new Signal("FPE"), handler);
        Signal.handle(new Signal("ABRT"), handler);
//        Signal.handle(new Signal("BREAK"), handler);
        for (;;) {
            System.out.println("do something");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}