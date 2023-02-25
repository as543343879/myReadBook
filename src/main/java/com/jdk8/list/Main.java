package com.jdk8.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Main class
 *
 * @author 格林
 * @date 2023-02-25
 */
public class Main {
    @Test
    public void test1(){
        ArrayList<String> list = new ArrayList<>();
        list.add("maple");
        list.add("leave");

        for (Iterator<String> iter = list.iterator(); iter.hasNext();) {
            String s = iter.next();
            System.out.println("----->>" + s);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("maple");
        list.add("leave");

        for (Iterator<String> iter = list.iterator(); iter.hasNext();) {
            String s = iter.next();
            System.out.println("----->>" + s);
        }
    }


}
