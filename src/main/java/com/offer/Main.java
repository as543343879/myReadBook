package com.offer;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
//字节跳动

public class Main {
    
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        System.out.println("Hello World!");
        int[] array = {1,2,3,4,5,1,1};
       System.out.println( zongShu(array ));
    }
    
    public static Integer zongShu(int[] array) {
        if(array == null || array.length == 0)
            return null;
      Map<Integer,Integer> map = new HashMap(array.length * 2);
        Integer value ;
      for(int i : array ) {
         value =   map.get(i);
          map.put(i, value == null ? 0  : value +  1);
      }  
       int max = 0;
        int index  = 0;


        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (  iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            if(next.getValue() > max) {
                max = next.getValue() ;
                index = next.getKey();
            }
        }

        return index;

    }
}