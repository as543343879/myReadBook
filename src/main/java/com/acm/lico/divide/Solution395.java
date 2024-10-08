package com.acm.lico.divide;

/**
 * Solution395 class
 *395. 至少有 K 个重复字符的最长子串
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aaabb", k = 3
 * 输出：3
 * 解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 示例 2：
 *
 * 输入：s = "ababbc", k = 2
 * 输出：5
 * 解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 * @author 谢小平
 * @date 2022/8/12
 */
/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
 空间复杂度
    O(1) 一个常量下完成
    O(n) 一次遍历
    O(logn) 折半查询
    O(n^2) 两重嵌套循环查询
 2 定位问题
思路一: 滑动窗口。
 思路二: 分治，找出ch，ch出现过，并且出现次数小于k的。 根据ch 去做分割，
    当 不出现ch，就是有答案
    当  出现ch，用ch 分割，子串 分治，选项最大的。 子串 重复上述的步骤。

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
 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 内存消耗： 39.6 MB , 在所有 Java 提交中击败了 63.93% 的用户
 通过测试用例： 36 / 36
 */
public class Solution395 {
    public int longestSubstring(String s, int k) {
        return  dfs(s,0,s.length()-1,k);
    }

    private int dfs(String s, int left, int right, int k) {
        int[] intMap = new int[26];
        for(int i = left; i <= right; i ++) {
            intMap[s.charAt(i) - 'a'] ++;
        }
        char split = 0;
        for(int i = 0; i < 26; i ++) {
            if (intMap[i] > 0 && intMap[i] < k) {
                split = (char) ('a' + i);
            }
        }

        if (split == 0) {
            return right - left + 1;
        }
        int i = left;
        int res = 0;
        while (i <= right) {
            while (i <= right && s.charAt(i) == split) {
                i ++;
            }
            if (left > right) {
                break;
            }
            int start = i;
            while (i <= right && s.charAt(i) != split) {
                i ++;
            }

            int len = dfs(s, start,i-1,k);
             res = Math.max(len, res);
        }
        return res;
    }
}
