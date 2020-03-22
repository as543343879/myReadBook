package com.mg.springjiemi.proxy.cglib;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;
public class SubjectCallback implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        try{
            System.out.println("-----Before Advice ------");
            if(method.getName().equals("request")){
                System.out.println("先跟秘书交谈，安全代理,虚拟代理,远程代理");
            }
            return methodProxy.invokeSuper(o,objects);
//            System.out.println("----- After returning advice -----");
        }catch (Exception e) {
            System.out.println("-----After throwing advice ------");
            return null;
        } finally {
            System.out.println("-----After advice ------");
        }
    }
}
