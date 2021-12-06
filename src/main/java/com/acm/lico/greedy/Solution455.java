package com.acm.lico.greedy;

import java.util.Arrays;

/**
 * Solution455 class
 * https://leetcode-cn.com/problems/assign-cookies/
 *455. 分发饼干
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 *
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 *
 *
 * @author 谢小平
 * @date 2021/12/6
 */
/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
    两个数组排序时间 O(m \log m + n \log n)O(mlogm+nlogn)
 空间复杂度
    两个数组排序空间 ：O(\log m + \log n)O(logm+logn)
 2 定位问题
    贪心
 3 数据操作分析

 4 编码实现
 5 执行结果
 执行结果： 通过 显示详情 添加备注 执行用时： 7 ms ,
 在所有 Java 提交中击败了 99.77% 的用户
 内存消耗： 39 MB ,
 在所有 Java 提交中击败了 84.24% 的用户
 通过测试用例： 21 / 21
 */

public class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int gi = 0, si = 0;

        while (gi < g.length && si < s.length) {

            while (si < s.length && s[si] < g[gi]  ) {
                si ++;
            }

            if(gi < g.length && si < s.length) {
                gi++;
                si++;
                count++;
            }

        }

        return count;
    }

    public static void main(String[] args) {
        int[] g = {1,2,3}, s = {1,1};
        System.out.println(new Solution455().findContentChildren(g,s));
    }
}
