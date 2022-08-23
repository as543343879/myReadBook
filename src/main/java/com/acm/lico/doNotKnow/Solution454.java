package com.acm.lico.doNotKnow;

import java.util.*;

/**
 * Solution454 class
 *https://leetcode.cn/problems/4sum-ii/
 * 454. 四数相加 II
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 *
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 * 输出：2
 * 解释：
 * 两个元组如下：
 * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
 * 示例 2：
 *
 * 输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
 * 输出：1
 *  
 *
 *   提示：
 *
 * n == nums1.length
 * n == nums2.length
 * n == nums3.length
 * n == nums4.length
 * 1 <= n <= 200
 * -228 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 228
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/4sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 格林
 * @date 2022-08-22
 */
/**
 1 复杂度分析
估算问题中复杂度的上限和下限
思路一：
 时间复杂度
 O(N^4)
 空间复杂度
 O(1)
 思路二：
 时间复杂度
 O(N^2)
 空间复杂度
O(N^2)

    O(1) 一个常量下完成
    O(n) 一次遍历
    O(logn) 折半查询
    O(n^2) 两重嵌套循环查询
 2 定位问题
根据问题类型，确定采用何种算法思维。

 思路1: 4重循环
 思路二: 两个map 对照

    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
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

    /**
     * 时间超限
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */
    public int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        int resCount = 0;
        for(int i1 = 0; i1 < nums1.length; i1 ++) {
            int target = 0;
            target += nums1[i1];
            for(int i2 = 0; i2 < nums2.length; i2 ++) {
                target += nums2[i2];
                for(int i3 = 0; i3 < nums3.length; i3 ++) {
                    target += nums3[i3];
                    for(int i4 = 0; i4 < nums4.length; i4 ++) {
                        target += nums4[i4];
                        if(target == 0) {
                            resCount++;
                        }
                        target -= nums4[i4];

                    }
                    target -= nums3[i3];
                }
                target -= nums2[i2];
            }


        }
        return resCount;
    }

    public static void main(String[] args) {
        System.out.println(new Solution454().fourSumCount(new int[]{1,2},new int[]{-2,-1},new int[]{-1,2},new int[]{0,2}));
    }
}
