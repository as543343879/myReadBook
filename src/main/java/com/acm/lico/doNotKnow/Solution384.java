package com.acm.lico.doNotKnow;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Solution384 class
 *384. 打乱数组
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。打乱后，数组的所有排列应该是 等可能 的。
 *
 * 实现 Solution class:
 *
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 *
 *
 * 示例 1：
 *
 * 输入
 * ["Solution", "shuffle", "reset", "shuffle"]
 * [[[1, 2, 3]], [], [], []]
 * 输出
 * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 *
 * 解释
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 1, 2]
 * solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
 * solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 50
 * -106 <= nums[i] <= 106
 * nums 中的所有元素都是 唯一的
 * 最多可以调用 104 次 reset 和 shuffle
 * @author 谢小平
 * @date 2022/8/8
 */
/**
 1 复杂度分析
估算问题中复杂度的上限和下限

 公平洗牌算法：

 时间复杂度
 O(N)
 空间复杂度
 O(N)
    O(1) 一个常量下完成
    O(n) 一次遍历
    O(logn) 折半查询
    O(n^2) 两重嵌套循环查询
 2 定位问题
 公平洗牌算法
根据问题类型，确定采用何种算法思维。
    例如
     这个问题是什么类型（排序、查找、最优化）的问题；
     这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
     采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 执行结果： 通过 显示详情 添加备注
 执行用时： 52 ms , 在所有 Java 提交中击败了 35.84% 的用户
 内存消耗： 47.3 MB , 在所有 Java 提交中击败了 36.47% 的用户
 通过测试用例： 8 / 8
 */
public class Solution384 {
    int[] nums;
    int[] backupNums;

    public Solution384(int[] nums) {
        this.nums = nums;
        backupNums = new int[nums.length];
        System.arraycopy(nums,0,backupNums,0,backupNums.length);
    }

    public int[] reset() {
//        重设数组到它的初始状态并返回
        System.arraycopy(backupNums,0,nums,0,nums.length);
        return this.nums;
    }

    public int[] shuffle() {
        // 返回数组随机打乱后的结果
        Random random = new Random();
        for(int i = nums.length ; i > 0; i --) {
            int index = random.nextInt(i);
            int t = nums[i-1];
            nums[i-1] = nums[index];
            nums[index] = t;
        }
        return this.nums;
    }


    public static void main(String[] args) {

    }
}
