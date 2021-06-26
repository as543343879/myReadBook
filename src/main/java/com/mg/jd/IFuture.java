package com.mg.jd;


import org.junit.Test;

import java.sql.Timestamp;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * IFuture class
 *
 * @author 谢小平
 * @date 2018/7/9
 */
public class IFuture             {
    final static ExecutorService executorService = Executors.newFixedThreadPool(2);

    /**
     * 耗时 24毫秒
     * @throws Exception
     */
    @Test
    public void test2() throws  Exception {
        Httpservice httpservice = new Httpservice();
        Rpcservice rpcservice = new Rpcservice();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Future<Integer> future1 = null;
        Future<Integer> future2 = null;
        try{
            future1 = executorService.submit(()->rpcservice.getRpcResult());
            future2 = executorService.submit(()->httpservice.getHttpResult());
            Integer result1 = future1.get(300, TimeUnit.MILLISECONDS);
            Integer result2 = future2.get(300, TimeUnit.MILLISECONDS);
            Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
            System.out.println(timestamp2.getTime()-timestamp.getTime());
        }catch (Exception e) {
            if(future1 != null) {
                future1.cancel(true);
            }
            if(future2 != null) {
                future2.cancel(true);
            }
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    /**
     * 耗时 32 毫秒
     * @throws Exception
     */
    @Test
    public void  test1() throws Exception {
        Httpservice httpservice = new Httpservice();
        Rpcservice rpcservice = new Rpcservice();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Integer t1 = rpcservice.getRpcResult();
        Integer t2 = httpservice.getHttpResult();
        Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp2.getTime()-timestamp.getTime());
    }

    static class  Rpcservice {
        Integer getRpcResult() throws  Exception{
            Thread.sleep(10);
            return 0;
        }
    }

    static class  Httpservice {
        Integer getHttpResult() throws  Exception{
            Thread.sleep(20);
            return 0;
        }
    }

}
