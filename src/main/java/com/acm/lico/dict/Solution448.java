package com.acm.lico.dict; /**
 448 ,找到所有数组中消失的数字
 //给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数
 //字，并以数组的形式返回结果。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：nums = [4,3,2,7,8,2,3,1]
 //输出：[5,6]
 //
 //
 // 示例 2：
 //
 //
 //输入：nums = [1,1]
 //输出：[2]
 //
 //
 //
 //
 // 提示：
 //
 //
 // n == nums.length
 // 1 <= n <= 10⁵
 // 1 <= nums[i] <= n
 //
 //
 // 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。
 //
 // Related Topics 数组 哈希表 👍 1128 👎 0

 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 1 复杂度分析
 估算问题中复杂度的上限和下限
 时间复杂度 O(N)
 空间复杂度 O(N)
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
 根据字典来标识是否存在
 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 解答成功:
 执行耗时:3 ms,击败了99.68% 的Java用户
 内存消耗:49.3 MB,击败了64.69% 的Java用户

 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int[] dict = new int[n + 1];
        for(int t : nums) {
            dict[t] ++;
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 1; i <= n; i ++ ) {
            if(dict[i] == 0) {
                res.add(i );
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
