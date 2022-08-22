package com.acm.lico.doNotKnow;

import java.util.*;

/**
 * Solution454 class
 *
 * @author 格林
 * @date 2022-08-22
 */
public class Solution454 {

    /**
     * 执行结果： 通过 显示详情 添加备注
     * 执行用时： 576 ms , 在所有 Java 提交中击败了 5.16% 的用户
     * 内存消耗： 41.5 MB , 在所有 Java 提交中击败了 50.27% 的用户
     * 通过测试用例： 132 / 132
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */
    public int fourSumCount3(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map12 = new HashMap<>();
        for(int i = 0; i < nums1.length; i ++) {
            for(int k = 0; k < nums2.length; k ++) {
                int t = nums1[i] + nums2[k];
                map12.put(t, map12.getOrDefault(t,0) + 1);
            }
        }

        Map<Integer,Integer>  map34= new HashMap<>();
        for(int i = 0; i < nums3.length; i ++) {
            for(int j = 0; j < nums4.length; j ++) {
                int t = nums3[i] + nums4[j];
                map34.put(t, map34.getOrDefault(t, 0) + 1);
            }
        }

        int res = 0;
        Set<Map.Entry<Integer, Integer>> entrySet1 = map12.entrySet();
        Set<Map.Entry<Integer, Integer>> entrySet2 = map34.entrySet();
        for(Map.Entry<Integer, Integer> t: entrySet1) {
            for (Map.Entry<Integer, Integer> k: entrySet2) {
                if((k.getKey() + t.getKey()) == 0) {
                    res += t.getValue() * k.getValue();
                }
            }
        }
        return res;
    }

    /**
     * 执行结果： 通过 显示详情 添加备注
     * 执行用时： 110 ms , 在所有 Java 提交中击败了 96.68% 的用户
     * 内存消耗： 41.3 MB , 在所有 Java 提交中击败了 82.26% 的用户
     * 通过测试用例： 132 / 132
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map12 = new HashMap<>();
        for(int i: nums1) {
            for(int k: nums2) {
                int t = i + k;
                map12.put(t, map12.getOrDefault(t,0) + 1);
            }
        }

        int res = 0;
        Map<Integer,Integer>  map34= new HashMap<>();
        for(int i: nums3) {
            for(int j : nums4) {
                int t = -i - j;
                res += map12.getOrDefault( t, 0);
            }
        }

        return res;
    }
}
