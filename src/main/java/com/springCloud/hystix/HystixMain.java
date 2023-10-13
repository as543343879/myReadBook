package com.springCloud.hystix;

import com.springCloud.hystix.dto.ProductInfo;
import org.junit.Test;

/**
 * HystixMain class
 *
 * @author 格林
 * @date 2023-10-13
 */
public class HystixMain {

    public static void main(String[] args) {
        GetProductInfoCommand getProductInfoCommand = new GetProductInfoCommand(1L);

        for(int i = 0 ; i < 10; i ++) {
            final int t = i;
            Thread thread = new Thread(
                    () -> {
                        GetProductInfoCommand getProductInfoCommand1 = new GetProductInfoCommand(1L);
                        ProductInfo execute = getProductInfoCommand1.execute();
                        System.out.println("index = " +t +"execute = " + execute);
                    }
            );
            thread.start();
        }
        System.out.println("-----------");

    }

    @Test
    public void test() {
        int size = 10;
        Thread[] threads = new Thread[size];
        for(int i = 0 ; i < size; i ++) {
            final int t = i;
            Thread thread = new Thread(
                    () -> {
                        GetProductInfoCommandThead getProductInfoCommand1 = new GetProductInfoCommandThead(1L);
                        ProductInfo execute = getProductInfoCommand1.execute();
                        System.out.println("index = " +t +"execute = " + execute);
                    }
            );
            thread.start();
            threads[i] = thread;


        }
        for(Thread thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("-----------");
    }
}
