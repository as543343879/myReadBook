package com.acm.lico.map;

/**
 * Solution387 class
 *387. 字符串中的第一个唯一字符
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: 0
 * 示例 2:
 *
 * 输入: s = "loveleetcode"
 * 输出: 2
 * 示例 3:
 *
 * 输入: s = "aabb"
 * 输出: -1
 * @author 谢小平
 * @date 2022/8/12
 */

/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 思路一： int字典，桶排序
 时间复杂度
 O(N)
 空间复杂度
 O(N)
    O(1) 一个常量下完成
    O(n) 一次遍历
    O(logn) 折半查询
    O(n^2) 两重嵌套循环查询
 2 定位问题
根据问题类型，确定采用何种算法思维。
思路一： int字典，桶排序
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 执行结果： 通过 显示详情 添加备注
 执行用时： 6 ms , 在所有 Java 提交中击败了 73.96% 的用户
 内存消耗： 42.1 MB , 在所有 Java 提交中击败了 21.16% 的用户
 通过测试用例： 105 / 105
 */
public class Solution387 {
    public int firstUniqChar(String s) {
        int maxIndex = 26;
       int[] intMap = new int[maxIndex];
       Integer[] indexArray = new Integer[maxIndex];
       for(int i = 0; i < s.length(); i ++) {
           int tempIndex = s.charAt(i) - 'a';
           intMap[tempIndex] ++;
           if(indexArray[tempIndex] == null) {
               indexArray[tempIndex] = i;
           }
       }
       int minIndex = Integer.MAX_VALUE;

       for(int i =0 ;i < maxIndex; i ++) {
           if(intMap[i] == 1) {
               minIndex = Math.min(minIndex, indexArray[i]);
           }
       }

       if (minIndex == Integer.MAX_VALUE) {
           return -1;
       }
       return minIndex;

    }
    public static void main(String[] args) {
        System.out.println(new Solution387().firstUniqChar("leetcode"));
    }
}
