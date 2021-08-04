package com.jdk8;

import org.junit.Test;

import java.util.Optional;

/**
 * OptionalTest class
 * https://mp.weixin.qq.com/s/dz_Mow_Ikdgy5_ukcfSvcg
 * @author 谢小平
 * @date 2021/7/26
 */
public class OptionalTest {
    public String getName() {
        System.out.print("method called");
        return "method called";
    }

    @Test
    public void testOrElse() {
        String str = null;
        String name1 = Optional.of(str).orElse(getName()); //output: method called
        String name2 = Optional.of(str).orElseGet(() -> getName()); //output:
    }


    @Test
    public void testPresent() {
        Optional optional = Optional.ofNullable("");
        Optional<Object> empty = Optional.empty();
        System.out.println(empty.isPresent());
        System.out.println(optional.isPresent());
    }
}
