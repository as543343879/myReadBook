package com.offer.huawei;

import java.util.*;

/**
 * Main class
 *
 * @author 格林
 * @date 2023-07-11
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String lineStr = in.nextLine();
            String[] arrayBox = lineStr.split(",");
            String nStr = in.nextLine();
            int n = Integer.parseInt(nStr);
            LinkedHashMap<String, List<Integer>> map = new LinkedHashMap<>();
            for(int i = 0; i < arrayBox.length; i ++) {
                String key = arrayBox[i];
                List<Integer> list = map.get(key);
                if(list == null) {
                    list = new ArrayList<>();
                    map.put(key, list);
                }
                list.add(i);
            }
            Set<Map.Entry<String, List<Integer>>> entries = map.entrySet();
            for(Map.Entry<String, List<Integer>> entry : entries) {
                List<Integer> values = entry.getValue();
                if(values.size() >= 2) {
                    for(int i = 1; i < values.size() ; i ++ ) {
                        if(values.get(i) - values.get(i-1) <= n) {
                            System.out.println(values.get(i-1));
                            return;
                        }
                    }
                }
            }

            System.out.println(-1);

        }
    }
}
