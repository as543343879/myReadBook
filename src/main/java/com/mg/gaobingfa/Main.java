package com.mg.gaobingfa;

import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Main class
 *  实战java 高并发程序设计 测试
 * @author xxp
 * @date 2018/7/13
 */
public class Main {
    @Test
    public void test1() {
        int[] iArr = {1,2,34,5};
        Arrays.stream(iArr).forEach(System.out::println);
    }

    @Test
    public void test2() {
        List<Integer>  nmubers = Arrays.asList(1,2,3);
        nmubers.forEach((Integer value) -> System.out.println(value));
    }

    @Test
    public void testUser(){
        List<User> users = new ArrayList<>();
        for(int i = 1; i < 10 ; i ++) {
            users.add(new User("name-" + i));
        }
        users.stream().map(User::getName).forEach(System.out::println);
    }


}
@Data
class User {
    public User(String name) {
        this.name = name;
    }

    private String name;
}