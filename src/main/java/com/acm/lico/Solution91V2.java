package com.acm.lico;

/**
 * Solution91 class
 *91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 *
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 *
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 *
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *
 * 1 复杂度分析 O(nlogn)
 *
 * 估算问题中复杂度的上限和下限
 * O(1) 一个常量下完成
 * O(n) 一次遍历
 * O(logn) 折半查询
 * O(n^2) 两重嵌套循环查询
 * 2 定位问题
 *
 * 根据问题类型，确定采用何种算法思维。 回溯 + 深度遍历
 * 例如
 * 这个问题是什么类型（排序、查找、最优化）的问题；
 * 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 * 采用哪些数据结构或算法思维，能把这个问题解决。
 * 3 数据操作分析
 *
 * 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 *
 *
 * # 结果
 * 时间超限。
 * @author 谢小平
 * @date 2021/8/4
 */
public class Solution91V2 {

    public int numDecodings(String s) {
       int n = s.length();
        s = " " + s;
       int[] f = new int[n + 1];
       f[0] = 1;
       for(int i = 1; i <= n; i  ++) {
           if(s.charAt(i) >= '1' &&  s.charAt(i) <= '9') {
               f[i] = f[i-1];
           }
           int b = (s.charAt(i-1)  - '0') * 10 + s.charAt(i)-'0';
           if(b >= 10 && b <= 26) {
               f[i] = f[i] + f[i - 2];
           }

       }
        return f[n];
    }


    public static void main(String[] args) {
        System.out.println(new Solution91V2().numDecodings2("10"));
    }
    public int numDecodings2(String s) {
        int n = s.length();
        s = " " + s;
        char[] cs = s.toCharArray();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            // a : 代表「当前位置」单独形成 item
            // b : 代表「当前位置」与「前一位置」共同形成 item
            int a = cs[i] - '0', b = (cs[i - 1] - '0') * 10 + (cs[i] - '0');
            // 如果 a 属于有效值，那么 f[i] 可以由 f[i - 1] 转移过来
            if (1 <= a && a <= 9)
                f[i] = f[i - 1];
            // 如果 b 属于有效值，那么 f[i] 可以由 f[i - 2] 或者 f[i - 1] & f[i - 2] 转移过来
            if (10 <= b && b <= 26)
                f[i] += f[i - 2];
        }
        return f[n];
    }



}
