package com.acm.lico.dict; /**
 1 ,两数之和
 //给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
 //
 // 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
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
 // Related Topics 数组 哈希表 👍 16424 👎 0

 **/

import java.util.HashMap;
import java.util.Map;

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
 空间复杂度 O(N)
 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 自己思路：
 遍历同时，把 target - nums[i] 存入hash表。 下一个 num[i] 如果命中。就是目标。

 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 自己思路：
 解答成功:
 执行耗时:2 ms,击败了77.06% 的Java用户
 内存消耗:41.8 MB,击败了34.41% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length;  i ++) {
            if(map.containsKey(nums[i])) {
                return new int[] { map.get(nums[i]), i};
            } else {
                map.put(target- nums[i], i);
            }
        }
        return null;
    }

    /**
     * 暴力 求解
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i ++) {
            for(int j = i + 1; j < nums.length; j ++) {
                if( nums[i] + nums[j]  == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    public int[] twoSum3(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length; i ++) {
            if( map.get( target - nums[i]) != null) {
                res[0] = map.get( target - nums[i]);
                res[1] = i;
                return res;
            }
            map.put(nums[i],i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
