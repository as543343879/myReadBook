package com.jdk8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ListTest class
 *
 * @author 格林
 * @date 2021-07-10
 */
public class ListTest {
    public static void main(String[] args) {
        List<String> sortList = new ArrayList<>();
        sortList.add("2");
        sortList.add("1");

        Collections.sort(sortList);

        System.out.println(sortList.toString());
    }
}
