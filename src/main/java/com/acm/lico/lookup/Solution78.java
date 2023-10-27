package com.acm.lico.lookup;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

/**
 子集:78
 2023-10-27 08:22:23
 //给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 //
 // 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：nums = [1,2,3]
 //输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 //
 //
 // 示例 2：
 //
 //
 //输入：nums = [0]
 //输出：[[],[0]]
 //
 //
 //
 //
 // 提示：
 //
 //
 // 1 <= nums.length <= 10
 // -10 <= nums[i] <= 10
 // nums 中的所有元素 互不相同
 //
 //
 // Related Topics 位运算 数组 回溯 👍 2173 👎 0

 **/

/**
 * Solution78 class
 *
 * @author 格林
 * @date 2023-10-27
 */
public class Solution78 {
    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度  O(N)
     空间复杂度  O(N)
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
     思路： 深度搜索+ 回溯
     1. 递归的终点，就是 递归的次数 等于长度n
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:0 ms,击败了100.00% 的Java用户
     内存消耗:40.7 MB,击败了54.61% 的Java用户
     */

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0) {
            return res;
        }
        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums , int len, List<Integer> tempRes) {
        res.add(new ArrayList<>(tempRes));
        for(int i = len; i < nums.length; i ++) {
            tempRes.add(nums[i]);
            dfs(nums, i + 1, tempRes);
            tempRes.remove(tempRes.size() - 1);
        }
    }
}
