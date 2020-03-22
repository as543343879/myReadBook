package com.mg.springjiemi.proxy;
import java.lang.reflect.Proxy;
public class InvocationHandlerClient {
    public static void main(String[] args) {
        ISubject subject = (ISubject) Proxy.newProxyInstance(ISubject.class.getClassLoader(),new Class[]{ISubject.class},new SubjectInvocationHadndler(new SubjectImpl()));
        String value = subject.request();
        System.out.println(value);
    }
}
