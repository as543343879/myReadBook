package com.mg.springjiemi.templatemethod;
public class VeicleShouDong extends Vehicle {
    @Override
    protected void putIntoGear() {
        System.out.println("手动挡");
    }
}
