package com.jdk8;

import java.util.Calendar;

/**
 * TimeTest class
 *
 * @author 谢小平
 * @date 2021/9/3
 */
public class TimeTest {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        Calendar timeCalendar = Calendar.getInstance();
       System.out.println( timeCalendar.getTime());
    }
}
