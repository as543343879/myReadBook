package com.acm.lico;

/**
 * Solution69 class
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 格林
 * @date 2021-06-19
 */
public class Solution69 {
    public int mySqrt(int x) {
        int low = 0 , high = x , res = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if((long) mid * mid <= x) {
                res = mid;
                low = mid + 1;
            } else  {
                high = mid - 1;
            }
        }
        return res;
    }
}
