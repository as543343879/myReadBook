package com.offer;

/**
 * Single class
 *
 * @author 格林
 * @date 2021-06-03
 */
public class Single {
    private static volatile Single single;

    public static Single getSingle() {
        if(single == null) {
            synchronized (Single.class) {
                if(single == null) {
                    single = new Single();
                }
            }
        }
        return single;
    }
    public static void main(String[] args) {

    }

    /**
     * qps 20w m/s  直播明星 variables
     * @param userId 推送系统 到点大量数据推送。
     * @return
     */
    public User test(String userId) {
        return null;
    }


}
