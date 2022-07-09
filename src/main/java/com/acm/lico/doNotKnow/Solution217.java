package com.acm.lico.doNotKnow;

/**
 * Solution217 class
 * https://leetcode.cn/problems/contains-duplicate/
 *217. 存在重复元素
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1]
 * 输出：true
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 示例 3：
 *
 * 输入：nums = [1,1,1,3,3,4,3,2,4,2]
 * 输出：true
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 通过次数606,680提交次数1,089,562
 * @author 格林
 * @date 2022-07-09
 */

import java.util.HashMap;
import java.util.Map;

/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
 O(N) N数组元素个数
 空间复杂度
 O(N) N数据元素个数
    O(1) 一个常量下完成
    O(n) 一次遍历
    O(logn) 折半查询
    O(n^2) 两重嵌套循环查询
 2 定位问题
根据问题类型，确定采用何种算法思维。
    借用 HASH 这种数据结构
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 执行结果： 通过 显示详情 添加备注
 执行用时： 12 ms , 在所有 Java 提交中击败了 50.97% 的用户
 内存消耗： 53.6 MB , 在所有 Java 提交中击败了 45.68% 的用户
 通过测试用例： 70 / 70
 */
public class Solution217 {
    /**
     * 看错题目 以为最大 109
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums) {
        int maxIndex = 109;
        int[] map = new int[maxIndex * 2];
        for(int i: nums) {
            map[i + maxIndex] ++;
        }
        for(int i: map) {
            if (i >= 2) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i: nums) {
            Integer count = map.get(i);
            if(count == null) {
                count = 0;
            }
            if (count >= 1) {
                return true;
            }
            map.put(i, count + 1);

        }
        return false;
    }
}
