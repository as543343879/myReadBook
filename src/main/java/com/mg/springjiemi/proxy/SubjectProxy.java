package com.mg.springjiemi.proxy;
public class SubjectProxy implements ISubject {
    ISubject iSubject;
    public SubjectProxy(ISubject iSubject) {
        this.iSubject = iSubject;
    }
    @Override
    public String request() {
        System.out.println("先跟秘书交谈，安全代理,虚拟代理,远程代理");
        return iSubject.request();
    }
}
