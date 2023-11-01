package com.offer.mayi;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * MapTest class
 *
 * @author 格林
 * @date 2023-11-01
 */
public class MapTest {
    public void mapTest() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "2");
        map.put("2", "3");
        Set<Map.Entry<String, String>> entrySets = map.entrySet();
        // for 打印
        for(Map.Entry<String, String> entry : entrySets)  {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        // stream 打印
        map.entrySet().stream().forEach(
                entry->{
                    System.out.println(entry.getKey() + ":" + entry.getValue());
                }
        );

    }


    public void threadTest() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(3);
        scheduledThreadPoolExecutor.scheduleWithFixedDelay(()->{
            System.out.println("hello world");
        }, 0,10, TimeUnit.MINUTES);
    }
}
