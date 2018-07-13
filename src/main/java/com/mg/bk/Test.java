package com.mg.bk;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
 
public class Test {
 
    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(StringBuilderTest.class.getSimpleName())
                .output("E:/Benchmark.log").forks(2).build();
        new Runner(options).run();
    }
}