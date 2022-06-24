package com.acm.lico.doNotKnow;

/**
 * https://leetcode.cn/problems/factorial-trailing-zeroes/
 * Solution172 class
 *172. 阶乘后的零
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 *
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：0
 * 解释：3! = 6 ，不含尾随 0
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：1
 * 解释：5! = 120 ，有一个尾随 0
 * 示例 3：
 *
 * 输入：n = 0
 * 输出：0
 * @author 格林
 * @date 2022-06-24
 */
public class Solution172 {
    /**
     * 超出时间限制
     * @param n
     * @return
     */
    public int trailingZeroes2(int n) {
        long ln = n;
        for(int i = n - 1; i > 0; i --) {
            ln *= n-1;
        }
        int count = 0;
        while ( ln % 10 == 0) {
            if(ln % 10 == 0) {
                count ++;
            }else {
                break;
            }

        }
        return count;

    }
    public static void main(String[] args) {
        System.out.println(new Solution172().trailingZeroes(200));
    }

    /**
     *
     * 执行结果： 通过 显示详情 添加备注
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 35.09% 的用户 内存消耗： 39 MB ,
     * 在所有 Java 提交中击败了 5.14% 的用户 通过测试用例： 500 / 500
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int res = 0;
        for(int i = 5; i < n; i += 5) {
            for (int k = i; k % 5 == 0; k /= 5) {
                res ++;
            }
        }
        return res;
    }
    /**
     *  1 2 3 4 5 6 7 8 9
     *  错误 没有进行分解  没有找到本质 例如 10 = 2 * 5
     * @param n
     * @return
     */
    public int trailingZeroes3(int n) {

        int res = 0 ;
        int n10 = n / 10;
        for(int i = 0; i < n10; i ++) {
//            res ++;

            int tCount = 0;
            int kEnd = (i + 1) * 10;
            int t = kEnd;
            while (t % 10 == 0) {
                t /= 10;
                tCount++;
            }
            if ( t > 0 && t % 5 == 0) {
                tCount++;
            }
            res += tCount;

            int kStart = i * 10;
            int tempRes = 1;
            for(int k = kStart + 2; k < kEnd; k += 2 ) {
                 t = k * (kStart + 5);
                 tCount = 0;
                while (t % 10 == 0) {
                    t /= 10;
                    tCount++;
                }
                if (tCount > tempRes) {
                    tempRes = tCount;
                }
            }
            res += tempRes;
        }
        if (n % 10 >= 5) {
            res ++;
        }
//        if ( n10 % 5 == 0) {
//            res ++;
//        }
        return res;
    }
}
