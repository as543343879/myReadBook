package com.mg.springjiemi.proxy.cglib;
import net.sf.cglib.proxy.Enhancer;
public class Client {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SubjectImpl.class);
        enhancer.setCallback(new SubjectCallback());
        SubjectImpl proxy = (SubjectImpl) enhancer.create();
        String value = proxy.request();
        System.out.println(value);
    }
}
