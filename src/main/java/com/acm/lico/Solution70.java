package com.acm.lico; /**
 70 ,爬楼梯
 //假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 //
 // 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：n = 2
 //输出：2
 //解释：有两种方法可以爬到楼顶。
 //1. 1 阶 + 1 阶
 //2. 2 阶
 //
 // 示例 2：
 //
 //
 //输入：n = 3
 //输出：3
 //解释：有三种方法可以爬到楼顶。
 //1. 1 阶 + 1 阶 + 1 阶
 //2. 1 阶 + 2 阶
 //3. 2 阶 + 1 阶
 //
 //
 //
 //
 // 提示：
 //
 //
 // 1 <= n <= 45
 //
 //
 // Related Topics 记忆化搜索 数学 动态规划 👍 2945 👎 0

 **/

import com.acm.lico.Solution70;

/**
 1 复杂度分析
 估算问题中复杂度的上限和下限
 时间复杂度
 空间复杂度
 O(1) 一个常量下完成
 O(n) 一次遍历
 O(logn) 折半查询
 O(n^2) 两重嵌套循环查询

 自己思路：
 时间复杂度 O(N)
 空间复杂度  O(1)
 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 自己思路：
 动态规划：
 dp[i] 表示有多少种方法可以爬上楼顶
 动态转移方程 dp[i] = dp[i-1] + dp[i -2]
 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 自己思路：
 解答成功:
 执行耗时:0 ms,击败了100.00% 的Java用户
 内存消耗:38.3 MB,击败了45.60% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution70 {
    public int climbStairs(int n) {
        if(n <= 0) {
            return 0;
        }
        int res = 1;

        int step1 = 1;
        int step2 = 2;
        for(int i = 3; i <= n; i ++) {
            res = step1 + step2;
            step1 = step2;
            step2 = res;
        }
        return n == 2 ? step2 : res;
    }

    public int climbStairs2(int n) {
        if(n == 1)
            return 1;
        int[] t = new int[n];
        t[0] = 1;
        t[1] = 2;
        for(int i = 2; i < n; i ++ ) {
            t[i] = t[i-1] + t[i-2];
        }
        return t[n - 1] ;
    }
    public static void main(String[] args) {
        new Solution70().climbStairs(2);
    }

}
//leetcode submit region end(Prohibit modification and deletion)
