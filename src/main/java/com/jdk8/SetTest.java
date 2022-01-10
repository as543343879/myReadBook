package com.jdk8;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * SetTest class
 *
 * @author 谢小平
 * @date 2022/1/10
 */
public class SetTest {

    @Test
    public void test1() {
        Set<String> testSet = new HashSet<String>(){
            {
                add("xxp");
                add("gelin");
            }
        };
        testSet.stream().forEach(System.out::println);
    }
}
