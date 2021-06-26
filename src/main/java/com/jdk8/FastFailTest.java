package com.jdk8;

import java.util.ArrayList;
import java.util.List;

/**
 * FastFailTest class
 *
 * @author 格林
 * @date 2021-06-20
 */
public class FastFailTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        for(int i : list) {
            if(i%2 == 0) {
                list.remove(i);
            }
        }

    }
}
