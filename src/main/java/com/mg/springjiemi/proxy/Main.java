package com.mg.springjiemi.proxy;
public class Main {
    public static void main(String[] args) {
        ISubject iSubject = new SubjectImpl();
        SubjectProxy proxy = new SubjectProxy(iSubject);
        String value = proxy.request();
        System.out.println(value);
    }
}
