package com.jdk8.completablefuture;

@FunctionalInterface
public interface ThriftAsyncCall {
    void invoke() throws TException ;
}