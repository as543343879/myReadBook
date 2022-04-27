package com.acm.lico;

/**
 * Solution128 class
 *128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * https://leetcode-cn.com/problems/longest-consecutive-sequence/
 * @author 谢小平
 * @date 2022/4/27
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
    O(n)
 空间复杂度
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
 执行用时： 18 ms , 在所有 Java 提交中击败了 47.53% 的用户
 内存消耗： 56.1 MB , 在所有 Java 提交中击败了 52.41% 的用户
 通过测试用例： 70 / 70
 */
public class Solution128 {
    /**
     *  这里判断 是否存在 官网的思路 是 x+1 并且 x 没有前驱， 就不会 x,x+1 多次进入循环
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> numsMap = new HashMap<>( nums.length * 4 / 3 + 1 );
        for (int i : nums) {
            numsMap.put(i,i);
        }
        int max = 1;
        int temp_max = 1;
        Set<Integer> is_visit = new HashSet<>(nums.length * 4 / 3 + 1);
        for(int i: nums ) {
            if( !is_visit.contains(i)  && ( numsMap.containsKey(i + 1) || numsMap.containsKey(i-1)) ) {
                int t = i + 1;
                while (numsMap.containsKey(t)) {
                    is_visit.add(t);
                    t ++;
                    temp_max ++;
                }
                t = i -1;
                while (numsMap.containsKey(t)) {
                    is_visit.add(t);
                    t --;
                    temp_max ++;
                }
                max = temp_max > max ? temp_max : max;
                temp_max = 1;
            }
            is_visit.add(i);

        }

        return max;
    }

    public static void main(String[] args) {
        int[] test_nums = {9,1,4,7,3,-1,0,5,8,-1,6};

//        test_nums = new int[]{100, 4, 200, 1, 3, 2};

        System.out.println(new Solution128().longestConsecutive(test_nums));
    }
}
