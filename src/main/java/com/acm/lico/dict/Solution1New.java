package com.acm.lico.dict; /**
 两数之和:1
 2025-02-10 23:21:10
 //给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
 //
 // 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 //
 // 你可以按任意顺序返回答案。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：nums = [2,7,11,15], target = 9
 //输出：[0,1]
 //解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 //
 //
 // 示例 2：
 //
 //
 //输入：nums = [3,2,4], target = 6
 //输出：[1,2]
 //
 //
 // 示例 3：
 //
 //
 //输入：nums = [3,3], target = 6
 //输出：[0,1]
 //
 //
 //
 //
 // 提示：
 //
 //
 // 2 <= nums.length <= 10⁴
 // -10⁹ <= nums[i] <= 10⁹
 // -10⁹ <= target <= 10⁹
 // 只会存在一个有效答案
 //
 //
 //
 //
 // 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？
 //
 // Related Topics 数组 哈希表 👍 19286 👎 0

 **/
/**
 1 复杂度分析
 估算问题中复杂度的上限和下限
 时间复杂度 O(N)
 空间复杂度 O(NlogN)
 O(1) 一个常量下完成
 O(n) 一次遍历
 O(logn) 折半查询
 O(n^2) 两重嵌套循环查询
 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如 map
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 解答成功:
 执行耗时:2 ms,击败了99.60% 的Java用户
 内存消耗:44.1 MB,击败了51.80% 的Java用户
 */
import java.util.HashMap;
import java.util.Map;
//leetcode submit region begin(Prohibit modification and deletion)
public class Solution1New {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> tempMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int rightValue = target - nums[i];
            if(tempMap.containsKey(rightValue)) {
                int leftIndex = tempMap.get(rightValue);
                return new int[] {leftIndex, i};
            }
            tempMap.put(nums[i], i);
        }
        return new int[]{0,1};

    }
}
//leetcode submit region end(Prohibit modification and deletion)
