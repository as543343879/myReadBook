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

//    private double pow(double x, int n) {
//        if(n == 1)
//            return x;
//        if( n == 0)
//            return 1D;
//       double t =  pow(x,n / 2);
//        return n % 2 == 0 ? t * t : t * t * x;
//    }


    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度  O(n/2) 错误 O(logN)
     空间复杂度  O(N/2   错误 O(logN)
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
     思路：时间超限
     1. 递归， 拆分为 x*x, n-1。 递归终点 n == 1.
     2. 假如 n < 0 。求出的值 1/res。
     思路：快速幂
     1. x^n。 假如 n 是偶数。 y^2 = x^n。那么 先求出 y 然后 y*y 就是结果， 如果是奇数， 那么就是 y*y*x。
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     解答成功:
     执行耗时:1 ms,击败了9.19% 的Java用户
     内存消耗:40.3 MB,击败了73.93% 的Java用户
     5 执行结果
     */
    public double myPowNew20(double x, int n) {
        if(n == 0) {
            return 1D;
        }
        return n >0 ? pow(x,n) : 1.0 / pow(x, -n);
    }


    private double pow(double x, int n) {
        if( n == 0) {
            return 1.0;
        }
        double temp = pow(x, n/2);
        return  ( (n & 1) == 0) ? temp * temp : x * temp * temp;
    }
}
