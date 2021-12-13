package com.bug.log4j;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public  class RemoteHelloWorld extends UnicastRemoteObject implements HelloWorld{
        protected RemoteHelloWorld() throws RemoteException { //需要抛出一个Remote异常的默认初始方法
            System.out.println("RemoteHelloWorld");
        }
        @Override
        public String Hello() throws RemoteException { //实现接口的方法
            return "Hello World!";
        }
        @Override
        public String HelloWorld() throws RemoteException{
            return "This is another method";
        }
    }