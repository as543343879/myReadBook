package com.designPatterns.observer.apollo;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.Map;
import java.util.Observable;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * DataSourcesCache class
 * 模拟定时读取某个文件，监控是否变化。
 * @author 谢小平
 * @date 2021/8/17
 */
@Slf4j
public class DataSourcesCache extends Observable {
    public static Map<String,Data>  cache = new ConcurrentHashMap<>();

    public  void init(){
        ThreadFactory threadFactory = new BasicThreadFactory.Builder().namingPattern("DataSourcesCache-%s").daemon(true).build();
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 2 , threadFactory);
        scheduledThreadPoolExecutor.scheduleWithFixedDelay(()->{
            Random random = new Random();
            Long i = random.nextLong();
            Data data = new Data();
            data.setId(i).setName("name" + i).setData("data" + i);

            String key = random.nextInt(2) == 1 ?  "gelin" : "gelin1" ;

            cache.put(key,data);

            super.setChanged();
            super.notifyObservers(key);
            log.info("change {} data {}",key, JSON.toJSONString(data));
        },5,5, TimeUnit.SECONDS);


    }


}
