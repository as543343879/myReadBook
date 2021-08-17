package com.designPatterns.observer.apollo;

/**
 * Main class
 *
 * @author 谢小平
 * @date 2021/8/17
 */
public class Main {
    public static void main(String[] args) {
        // 配置数据来源 通过定时刷新
        DataSourcesCache dataSourcesCache = new DataSourcesCache();
        dataSourcesCache.init();


        DataSourcesClient dataSourcesClient = new DataSourcesClient();
        dataSourcesClient.setName("gelin");

        DataSourcesClient dataSourcesClient2 = new DataSourcesClient();
        dataSourcesClient2.setName("gelin1");

        dataSourcesCache.addObserver(dataSourcesClient);
        dataSourcesCache.addObserver(dataSourcesClient2);
        synchronized (Main.class) {
            try {
                Main.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
