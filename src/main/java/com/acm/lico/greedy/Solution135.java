package com.acm.lico.greedy; /**
 135 ,分发糖果
 //n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 //
 // 你需要按照以下要求，给这些孩子分发糖果：
 //
 //
 // 每个孩子至少分配到 1 个糖果。
 // 相邻两个孩子评分更高的孩子会获得更多的糖果。
 //
 //
 // 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：ratings = [1,0,2]
 //输出：5
 //解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 //
 //
 // 示例 2：
 //
 //
 //输入：ratings = [1,2,2]
 //输出：4
 //解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 //     第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 //
 //
 //
 // 提示：
 //
 //
 // n == ratings.length
 // 1 <= n <= 2 * 10⁴
 // 0 <= ratings[i] <= 2 * 10⁴
 //
 //
 // Related Topics 贪心 数组 👍 1040 👎 0

 **/
/**
 1 复杂度分析
 估算问题中复杂度的上限和下限
 O(n)
 时间复杂度
 空间复杂度
 O(1) 一个常量下完成
 O(n) 一次遍历
 O(logn) 折半查询
 O(n^2) 两重嵌套循环查询

 candy1:
 时间复杂度 O(N)
 空间复杂度 O(N)

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
 candy1:
 解答成功:
 执行耗时:2 ms,击败了98.64% 的Java用户
 内存消耗:42.2 MB,击败了31.85% 的Java用户
 candy2:
 > 2022/11/03 14:53:24
 解答成功:
 执行耗时:2 ms,击败了98.64% 的Java用户
 内存消耗:41.9 MB,击败了72.01% 的Java用户

 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution135 {

    public int candy2(int[] ratings) {
        int n = ratings.length;
        int[] leftRatings = new int[n];
        leftRatings[0] = 1;
        for(int i = 1; i < n; i ++) {
            if(ratings[i] > ratings[i-1]) {
                leftRatings[i] =  leftRatings[i-1] + 1;
            } else {
                leftRatings[i] = 1;
            }
        }
        int rightRes = 1;
        int res  = leftRatings[n-1];
        for(int i = n - 2; i >=0; i --) {
            if(ratings[i] > ratings[i+1]) {
                rightRes = rightRes + 1;
            } else {
                rightRes = 1;
            }
            res +=Math.max(leftRatings[i], rightRes);
        }
        return res;

    }

    public int candy1(int[] ratings) {
        int n = ratings.length;
        int[] leftRatings = new int[n];
        int[] rightRatings = new int[n];
        leftRatings[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                leftRatings[i] = leftRatings[i - 1] + 1;
            } else {
                leftRatings[i] = 1;
            }
        }
        rightRatings[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                rightRatings[i] = rightRatings[i + 1] + 1;
            } else {
                rightRatings[i] = 1;
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.max(leftRatings[i], rightRatings[i]);
        }
        return res;

    }
    public static void main(String[] args) {
//        System.out.println(new Solution135().candy(new int[]{1,0,2,3,5}));

        System.out.println(new Solution135().candy1(new int[]{1,2,87,87,87,2,1}));
    }
}
