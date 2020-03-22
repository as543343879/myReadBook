package com.mg.springjiemi.templatemethod;
public abstract class Vehicle {
    //模板方法
    public final void  drive(){
        //点火启动汽车
        startTheEngine();
        //挂挡 可能有手动挡，自动挡
        putIntoGear();
        //跑路
        go();
    }
    //开车的步骤
    protected  abstract void putIntoGear();
    //开车的步骤
    public void go(){
        //...
        System.out.println("跑路");
    }
    public void startTheEngine(){
        //...
        System.out.println("开火");
    }

}
