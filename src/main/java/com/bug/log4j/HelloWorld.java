package com.bug.log4j;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloWorld extends Remote {
        public String Hello() throws RemoteException; //定义的方法需要抛出RemoteException的异常
        public String HelloWorld() throws RemoteException;
        /*
        * 由于任何远程方法调用实际上要进行许多低级网络操作，因此网络错误可能在调用过程中随时发生。
           因此，所有的RMI操作都应放到try-catch块中
        * */
    }