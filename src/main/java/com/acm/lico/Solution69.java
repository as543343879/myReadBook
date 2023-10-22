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
    public static void main(String[] args) {
        System.out.println(new Solution69().mySqrt(20));
    }
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
     思路：
     1. 通过  t = x / 2 。然后 t*t <= x;
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:9 ms,击败了12.02% 的Java用户
     内存消耗:38.5 MB,击败了65.38% 的Java用户
     */
    public int mySqrtNew20(int x) {
        long t = x;
        while (t*t > x) {
            t /= 2;
        }
        for(long i = t*2; i >= t; i --) {
            if(i * i <= x) {
                return (int) i;
            }
        }
        return (int)t ;
    }
}
