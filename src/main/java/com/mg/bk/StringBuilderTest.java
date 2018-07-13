package com.mg.bk;

import org.openjdk.jmh.annotations.*;
 
import java.util.concurrent.TimeUnit;
 
/**
 * author: zhaoye
 * date: 2016/11/4 14:36
 */
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 3)
@Measurement(iterations = 10, time = 5, timeUnit = TimeUnit.SECONDS)
@Threads(16)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class StringBuilderTest {
 
    @Benchmark
    public void testStringAdd() {
        String a = "";
        for (int i = 0; i < 10; i++) {
            a += i;
        }
        print(a);
    }
 
    @Benchmark
    public void testStringBuilderAdd() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(i);
        }
        print(sb.toString());
    }
 
    private void print(String a) {
    }
}
