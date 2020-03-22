package com.mg.springjiemi.proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
public class SubjectInvocationHadndler implements InvocationHandler {
    private  Object target;
    public SubjectInvocationHadndler(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try{
            System.out.println("-----Before Advice ------");
            if(method.getName().equals("request")){
                System.out.println("先跟秘书交谈，安全代理,虚拟代理,远程代理");
            }
            return method.invoke(target,args);
//            System.out.println("----- After returning advice -----");
        }catch (Exception e) {
            System.out.println("-----After throwing advice ------");
            return null;
        } finally {
            System.out.println("-----After advice ------");
        }
    }
}
