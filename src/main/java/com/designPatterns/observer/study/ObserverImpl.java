package com.designPatterns.observer.study;

public class ObserverImpl implements Observer {
    @Override
    public void notify(String acct, double amt) {
        System.out.println("=== 接收到通知：账户："+acct + " 账单："+amt);
    }
}