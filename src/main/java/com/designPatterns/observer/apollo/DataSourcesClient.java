package com.designPatterns.observer.apollo;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Observable;
import java.util.Observer;

/**
 * DataSourcesClient class
 * 客户端读取配置文件
 * @author 谢小平
 * @date 2021/8/17
 */
@Data
@Slf4j
public class DataSourcesClient implements Observer {
    private String name;
    private com.designPatterns.observer.apollo.Data data;
    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof String) {
            String key = (String) arg;
            if(key.equals(name)){
                data = DataSourcesCache.cache.get(arg);
                log.info("name: {}, change : {}", name,JSON.toJSONString(data));
            }

        }
    }
}
