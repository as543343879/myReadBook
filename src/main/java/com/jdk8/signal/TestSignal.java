package com.jdk8.signal;

import sun.misc.Signal;
import sun.misc.SignalHandler;

@SuppressWarnings("restriction")
public class TestSignal implements SignalHandler {

    @SuppressWarnings("restriction")
    @Override
    public void handle(Signal signal) {
        System.out.println(signal.getName() + " is recevied.");
    }
}