package com.hystrix;

import com.google.common.util.concurrent.RateLimiter;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * Limit class
 *
 * @author 格林
 * @date 2023-11-05
 */
@Slf4j
@Data
public class TaskRateLimitManager {


    private RateLimiter rateLimiter;

    public TaskRateLimitManager() {
        this.rateLimiter = RateLimiter.create(1);
    }

    private void init() {

    }

    /**
     * 修改 qps
     *
     * @param qps
     */
    public void changeQps(double qps) {
        log.info("qps is change. qps = {}", qps);
        rateLimiter.setRate(qps);
    }

    /**
     * 获取 1 个令牌，永不停歇。注意这里是阻塞的
     */
    public void acquire() {
        acquire(1);
    }

    /**
     * 获取 permits 个令牌，永不停歇。注意这里是阻塞的
     *
     * @param permits 令牌数量，小于等于 0 会直接 return
     */
    public void acquire(int permits) {
        if (permits <= 0) {
            return;
        }
        int tryTimes = 0;
        while (true) {
            tryTimes++;
            // 尝试在超时时间内获取
            boolean isAcquired = rateLimiter.tryAcquire(10);
//            boolean isAcquired = rateLimiter.tryAcquire(permits, 200, TimeUnit.MILLISECONDS);
            if (isAcquired) {
                return;
            }
            try {
                LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(200));
            } catch (Exception e) {
                log.warn("park error.", e);
            }
            log.info("rateLimiter tryAcquire fail. try again. tryTimes={}", tryTimes);
            // 重试次数有上限，超过了就直接 pass，防止线程等太久 应该加上指数级退避
            if (tryTimes >= 100) {
                log.info("rateLimiter tryTimes >= {}, pass!", tryTimes);
                break;
            }
        }
    }

    public static void main(String[] args) {
        TaskRateLimitManager taskRateLimitManager = new TaskRateLimitManager();
        taskRateLimitManager.acquire(20);
        taskRateLimitManager.acquire(1);
        System.out.println("--");
    }

}

