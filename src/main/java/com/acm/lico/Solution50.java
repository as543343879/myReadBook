package com.acm.lico;

/**
 * Solution50 class
 *50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 *
 *
 * @author 格林
 * @date 2021-06-30
 */
public class Solution50 {
    public double myPow(double x, int n) {

        return  n > 0 ? pow(x,n) : 1.0 / pow(x,-n);
    }

    private double pow(double x, int n) {
        if(n == 1)
            return x;
        if( n == 0)
            return 1D;
       double t =  pow(x,n / 2);
        return n % 2 == 0 ? t * t : t * t * x;
    }
}
