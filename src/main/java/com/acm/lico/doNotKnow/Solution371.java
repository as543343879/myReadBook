package com.acm.lico.doNotKnow;

/**
 * Solution371 class
 * https://leetcode.cn/problems/sum-of-two-integers/
 *371. 两整数之和
 * 给你两个整数 a 和 b ，不使用 运算符 + 和 - ​​​​​​​，计算并返回两整数之和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：a = 1, b = 2
 * 输出：3
 * 示例 2：
 *
 * 输入：a = 2, b = 3
 * 输出：5
 *
 *
 * 提示：
 *
 * -1000 <= a, b <= 1000
 * 通过次数96,245提交次数156,558
 * @author 谢小平
 * @date 2022/7/27
 */
/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
 O(logN)
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
 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 内存消耗： 37.9 MB , 在所有 Java 提交中击败了 91.06% 的用户
 通过测试用例： 25 / 25
 */
public class Solution371 {
    /**
     * 原码
     * toBinaryString 二进制表示的是补码
     * 反码 除了符号位取反。
     * 正数 的 补码 反码 是他本身
     * 负数 的 补码 是反码加1
     *
     *
     * \进位
     * 只有 a&b 的位 左移
     * 其余位 还是 a^ b
     *
     * ……
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a, int b) {
        while (b != 0 ) {
            int k = (a&b) << 1;
            a = a ^ b;
            b = k;
        }
        return a;
    }
    public static void main(String[] args) {
        System.out.println(new Solution371().getSum(1,2));
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(-1));
    }
}
