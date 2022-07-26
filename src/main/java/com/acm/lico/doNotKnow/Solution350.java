package com.acm.lico.doNotKnow;

import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;

import java.util.*;

/**
 * Solution350 class
 * https://leetcode.cn/problems/intersection-of-two-arrays-ii/
 *350. 两个数组的交集 II
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 *
 * 提示：
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 *
 *
 * 进阶：
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 *   直接遍历一遍就可以得到结果
 * 如果 nums1 的大小比 nums2 小，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * 通过次数382,616提交次数678,292
 * @author 格林
 * @date 2022-07-26
 */
/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
 O(N+M)
 空间复杂度
 O(N+M)
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
 执行结果： 通过 显示详情 添加备注
 执行用时： 3 ms , 在所有 Java 提交中击败了 39.17% 的用户
 内存消耗： 41.8 MB , 在所有 Java 提交中击败了 9.43% 的用户 通
 过测试用例： 56 / 56
 */
public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map1 = new HashMap<>(nums1.length * 4 / 3  +1);
        Map<Integer,Integer> map2 = new HashMap<>(nums2.length * 4 / 3 + 1);
        for(int i: nums1) {
            Integer temp = map1.get(i);
            map1.put(i, temp == null ? 1:temp + 1 );
        }
        // 这里可以优化， 直接遍历 就可以对照 map1 。然后 用nums2 当作存储空间 。 空间复杂度 O(N)
        for(int i : nums2) {
            Integer temp = map2.get(i);
            map2.put(i, temp == null ? 1 : temp + 1);
        }
        List<Integer> resList = new ArrayList<>();
        Set<Map.Entry<Integer, Integer>> set1 = map1.entrySet();
        for(Map.Entry<Integer,Integer> t:  set1) {
            if(map2.containsKey(t.getKey())) {
                int min = Math.min(map2.get(t.getKey()), t.getValue());
                while (min > 0) {
                    resList.add(t.getKey());
                    min--;
                }

            }
        }
        int[] resArray = new int[resList.size()];
        for(int i = 0; i < resList.size(); i ++) {
            resArray[i] = resList.get(i);
        }
        return resArray;
    }


    /**
     * difference
     * Maps.difference(Map, Map)用来比较两个Map以获取所有不同点。该方法返回MapDifference对象
     */
    public static void u(Map<String,Object> map1, Map<String,Object> map2) {
        MapDifference<String, Object> difference = Maps.difference(map1, map2);
        // 是否有差异，返回boolean
        boolean areEqual = difference.areEqual();
        System.out.println("比较两个Map是否有差异:" + areEqual);
        // 两个map的交集
        Map<String, Object> entriesInCommon = difference.entriesInCommon();
        System.out.println("两个map都有的部分（交集）===：" + entriesInCommon);
        // 键相同但是值不同值映射项。返回的Map的值类型为MapDifference.ValueDifference，以表示左右两个不同的值
        Map<String, MapDifference.ValueDifference<Object>> entriesDiffering = difference.entriesDiffering();
        System.out.println("键相同但是值不同值映射项===：" + entriesDiffering);
        // 键只存在于左边Map的映射项
        Map<String, Object> onlyOnLeft = difference.entriesOnlyOnLeft();
        System.out.println("键只存在于左边Map的映射项:" + onlyOnLeft);
        // 键只存在于右边Map的映射项
        Map<String, Object> entriesOnlyOnRight = difference.entriesOnlyOnRight();
        System.out.println("键只存在于右边Map的映射项:" + entriesOnlyOnRight);
    }
}
