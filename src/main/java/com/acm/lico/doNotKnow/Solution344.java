package com.acm.lico.doNotKnow;

/**
 * Solution344 class
 *
 * https://leetcode.cn/problems/reverse-string/
 *344. 反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = ["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 *
 * 输入：s = ["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * @author 格林
 * @date 2022-07-24
 */
/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
 O(N)
 空间复杂度
 O(1)
    O(1) 一个常量下完成
    O(n) 一次遍历
    O(logn) 折半查询
    O(n^2) 两重嵌套循环查询
 2 定位问题
 前后 交换位置
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
 内存消耗： 47.9 MB , 在所有 Java 提交中击败了 84.53% 的用户
 通过测试用例： 477 / 477 炫耀一下:
 */
public class Solution344 {
    public void reverseString(char[] s) {
        int middle = (s.length - 1) / 2;
        int n = s.length-1;
        for(int i = 0; i <= middle; i ++) {
            char t = s[i];
            s[i] = s[n - i];
            s[n-i] = t;
        }
    }

    public static void main(String[] args) {

    }
}
