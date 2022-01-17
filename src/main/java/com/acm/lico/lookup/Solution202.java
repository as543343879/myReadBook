package com.acm.lico.lookup;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：
 *
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为  1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 true ；不是，则返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/happy-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 执行用时： 1 ms , 在所有 Java 提交中击败了 88.80% 的用户
 内存消耗： 35.3 MB , 在所有 Java 提交中击败了 79.54% 的用户
 通过测试用例： 402 / 402
 */
class Solution202 {
    public boolean isHappy(int n) {
        int count = 0;
        while (n != 1) {
            int temp = n;
            n = 0;
            count ++;
            while (temp  != 0 ) {
                n += Math.pow(temp % 10, 2);
                temp /= 10;
            }
            if (count >= 500) {
                return false;
            }
        }
        return true;
    }

    public static  boolean isHappyViolence(int n) {
        return new Solution202().isHappy(n);
    }

    public static void main(String[] args) {
        for(int i = 1; i < 101 ; i ++) {
            boolean happyViolence = isHappyViolence(i);
            if(happyViolence) {
                System.out.println(i + " : " + happyViolence);
            }
        }
    }
}