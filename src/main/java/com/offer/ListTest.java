package com.offer;

import java.util.*;

/**
 * ListTest class
 *
 * @author 格林
 * @date 2021-05-31
 */
public class ListTest {
    public static Map<String,String>  merg(List<Integer> list){
        int len = list.size();
        int count = 100;
        Map<String,String> map = new HashMap<>();
        for(int i = 0; i < len; i ++) {
            for(int j = 0; j < len; j ++) {
                if(i != j && list.get(i) + list.get(j) == count)  {
                    if(i < j) {
                        map.put(i + "" + j,list.get(i) + "-" + list.get(j));
                    } else {
                        map.put(j + "" + i, list.get(i) + "-" + list.get(j));
                    }
                }
            }
        }
        return map;
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        list.add(30);
            list.add(70);
        list.add(30);
            list.add(70);
        list.add(50);
        list.add(50);
        list.add(60);
        Map<String, String> map = merg(list);
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next.getValue());
        }
    }
}
