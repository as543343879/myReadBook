package com.mg.springjiemi.proxy;
public class SubjectProxy implements ISubject {
    ISubject iSubject;
    public SubjectProxy(ISubject iSubject) {
        this.iSubject = iSubject;
    }
    @Override
    public String request() {
        System.out.println("先跟秘书交谈，秘书记录你的信息，等等");
        return iSubject.request();
    }
}
