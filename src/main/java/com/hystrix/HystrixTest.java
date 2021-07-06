package com.hystrix;

import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolProperties;

/**
 * HystrixTest class
 *
 * @author 格林
 * @date 2021-07-06
 */
public class HystrixTest {
    public static void main(String[] args) {
        HystrixCommandProperties.Setter().withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD);
        HystrixCommandProperties.Setter().withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE);
        HystrixThreadPoolProperties.Setter().withMaxQueueSize(111);
    }
}
