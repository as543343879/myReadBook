package com.acm.lico.lookup;

/**
 * Solution349 class
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 *349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *
 * @author 谢小平
 * @date 2021/12/31
 */

import java.util.*;

/**
 * intersection
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
 O(n*m)
 空间复杂度
 O(n^M)
    O(1) 一个常量下完成
    O(n) 一次遍历
    O(logn) 折半查询
    O(n^2) 两重嵌套循环查询
 2 定位问题
根据问题类型，确定采用何种算法思维。
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 执行用时： 13 ms , 在所有 Java 提交中击败了 5.99% 的用户
 内存消耗： 39 MB , 在所有 Java 提交中击败了 5.13% 的用户
 */
public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length == 0 ) {
            return nums1;
        } else if(nums2.length == 0 ) {
            return nums2;
        }
        Set<Integer> res = new HashSet<>();
        for(int nums1Value : nums1) {
            for(int nums2Value : nums2) {
                if(nums1Value == nums2Value) {
                    res.add(nums1Value);
                }
            }
        }
        return  res.stream().mapToInt(x -> x).toArray();

    }

    /**
     *  时间复杂度
     *  O(n)
     *  空间复杂度
     *   O(n)
     * 执行用时： 6 ms , 在所有 Java 提交中击败了 10.04% 的用户
     * 内存消耗： 38.9 MB , 在所有 Java 提交中击败了 5.13% 的用户
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        Map<Integer,Integer> intersectionMap = new HashMap<>();
        Arrays.stream(nums1).forEach(key -> intersectionMap.put(key,1) );
        List<Integer> resInt = new LinkedList<>();
       Arrays.stream(nums2).forEach(key->{
           Integer value = intersectionMap.get(key);
           if(new Integer(1).equals(value)) {
               intersectionMap.put(key, 2);
               resInt.add(key);
           }
       });
       return resInt.stream().mapToInt(x->x).toArray();
    }

    /**
     * 执行用时： 5 ms , 在所有 Java 提交中击败了 13.46% 的用户
     * 内存消耗： 38.5 MB , 在所有 Java 提交中击败了 60.44% 的用户
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection3(int[] nums1, int[] nums2) {
        Map<Integer,Integer> intersectionMap = new HashMap<>();
        if(nums1.length > nums2.length) {
            int[] nums3 = nums1;
            nums1 = nums2;
            nums2 = nums3;
        }

        Arrays.stream(nums1).forEach(key -> intersectionMap.put(key,1) );
        List<Integer> resInt = new LinkedList<>();
        Arrays.stream(nums2).forEach(key->{
            Integer value = intersectionMap.get(key);
            if(new Integer(1).equals(value)) {
                intersectionMap.put(key, 2);
                resInt.add(key);
            }
        });
        return resInt.stream().mapToInt(x->x).toArray();
    }

    public  int size(int size) {
        if(size <= 11) {
            return 16;
        }
        return (int) (size / 0.75F + 1);
    }

    /**
     * 执行用时： 5 ms , 在所有 Java 提交中击败了 13.46% 的用户
     * 内存消耗： 38.8 MB , 在所有 Java 提交中击败了 12.05% 的用户
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection4(int[] nums1, int[] nums2) {

        if(nums1.length > nums2.length) {
            int[] nums3 = nums1;
            nums1 = nums2;
            nums2 = nums3;
        }
        Map<Integer,Integer> intersectionMap = new HashMap<>(size(nums1.length));
        for(int i : nums1) {
            intersectionMap.put(i,1);
        }
        List<Integer> resInt = new LinkedList<>();

        for(int i : nums2) {
            Integer value = intersectionMap.get(i);
            if(new Integer(1).equals(value)) {
                intersectionMap.put(i, 2);
                resInt.add(i);
            }
        }
        return resInt.stream().mapToInt(x->x).toArray();
    }
}
