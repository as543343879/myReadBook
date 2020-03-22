package com.mg.springjiemi.templatemethod;
//自动挡汽车
public class VehicleZiDong extends Vehicle {
    @Override
    protected void putIntoGear() {
        System.out.println("挂自动挡");
    }
}
