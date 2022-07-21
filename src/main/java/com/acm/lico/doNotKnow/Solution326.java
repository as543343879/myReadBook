package com.acm.lico.doNotKnow;

/**
 * Solution326 class
 * https://leetcode.cn/problems/power-of-three/
 *326. 3 的幂
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 27
 * 输出：true
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：false
 * 示例 3：
 *
 * 输入：n = 9
 * 输出：true
 * 示例 4：
 *
 * 输入：n = 45
 * 输出：false
 * @author 谢小平
 * @date 2022/7/21
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
根据问题类型，确定采用何种算法思维。
 每位数 相加 是否 能被三整除。 不能先过滤
 然后根据对数过滤
 log(x)(y) =log(e)(y) / log(e)(x)

 。 官方思路
 思路一：
 这个数 是不是 3^max 的最大约数。
 思路二：
 这个数 不断除 3。 回不会 最后等于 == 1
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 执行结果： 通过 显示详情 添加备注
 执行用时： 8 ms , 在所有 Java 提交中击败了 79.38% 的用户
 内存消耗： 41 MB , 在所有 Java 提交中击败了 64.44% 的用户
 通过测试用例： 21038 / 21038
 */
public class Solution326 {
    public boolean isPowerOfThree(int n) {
        if(n == 0) {
            return false;
        } else if(n == 1) {
            return true;
        }
        else if (n % 3 != 0) {
            return false;
        }
        double pow = mathLog(3,n);
        double t = Math.ceil(pow);
        if(t - pow  <= 0.0000001) {
            return true;
        }

        return false;
    }
     static public double mathLog( double base, double value) {
        return Math.log(value) / Math.log(base);
    }

    public static void main(String[] args) {
     System.out.println(45 % 3 );
     System.out.println(mathLog(3,1));
     System.out.println(new Solution326().isPowerOfThree(243));
    }
}
