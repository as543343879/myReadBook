package com.acm.lico.doNotKnow;

import java.util.Arrays;

/**
 * Solution204 class
 * https://leetcode.cn/problems/count-primes/
 *204. 计数质数
 * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 *
 * 输入：n = 1
 * 输出：0
 *
 * @author 格林
 * @date 2022-07-03
 */
/**
 1 复杂度分析
估算问题中复杂度的上限和下限
 时间复杂度
 o(nlogn)
 空间复杂度
O(n)
 2 定位问题
根据问题类型，确定采用何种算法思维。
 根据是素数，反推 后面不是素数的
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 */
public class Solution204 {
    public boolean isPrime(int n) {
        boolean res = true;
        for (int i = 2; i * i<= n; i ++) {
            if( n % i == 0) {
                return false;
//                res = false;
//                break;
            }
        }
        return true;
//        return res;
    }

    /**
     *时间超限
     * @param n
     * @return
     */
    public int countPrimes2(int n) {
        int count = 0;
        for (int i = 2; i < n; i ++ ) {
            if(isPrime(i)){
                count++;
            }
        }
        return count;
    }

    /**
     *
     * 执行结果： 通过 显示详情 添加备注 执行用时： 131 ms ,
     * 在所有 Java 提交中击败了 55.04% 的用户 内存消耗： 45.7 MB ,
     * 在所有 Java 提交中击败了 71.62% 的用户 通过测试用例： 66 / 66
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        int count = 0;
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        for(int i = 2; i < n; i ++) {
            if(primes[i]) {
                count++;
                for(int k = 2; k * i <= n; k ++) {
                    primes[k*i] = false;
                }
            }

        }
        return count;


    }
}
