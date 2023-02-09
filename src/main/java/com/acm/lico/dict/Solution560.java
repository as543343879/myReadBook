package com.acm.lico.dict; /**
 560 ,和为 K 的子数组
 //给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：nums = [1,1,1], k = 2
 //输出：2
 //
 //
 // 示例 2：
 //
 //
 //输入：nums = [1,2,3], k = 3
 //输出：2
 //
 //
 //
 //
 // 提示：
 //
 //
 // 1 <= nums.length <= 2 * 10⁴
 // -1000 <= nums[i] <= 1000
 // -10⁷ <= k <= 10⁷
 //
 //
 // Related Topics 数组 哈希表 前缀和 👍 1800 👎 0

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

 官网思路：
 时间复杂度O(N^2)
 空间复杂度O(1)

 官方思路2：
 时间复杂度O(N)
 空间复杂度O(N)

 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 自己思路：
 枚举 以left 为起点的值， right 为终点是否等于 k。
 然后枚举
 然后右移一位，或者 右边 j+1 是否等于k

 官网思路： 自己思路错了，以为是连续个和为k 的数组。 只要和为k就可以了
 枚举从左到右的所有起点：
 以当前起点从右到左 等于k 的。

 官方思路2：
 假如  下标 i,j 和为 k。 sum(j) - sum(j-1) = k;
 sum[j] - k = sum[j-1]
 用map 把 从左到右的 sum记录起来。假如count += map.get(sum[j] -k);



 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 官网思路：
 解答成功:
 执行耗时:1842 ms,击败了5.06% 的Java用户
 内存消耗:44.7 MB,击败了75.04% 的Java用户

 解答成功:
 执行耗时:1171 ms,击败了38.16% 的Java用户
 内存消耗:44.8 MB,击败了68.24% 的Java用户

 官方思路2：
 解答成功:
 执行耗时:22 ms,击败了89.34% 的Java用户
 内存消耗:45 MB,击败了61.53% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution560 {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        Map<Integer,Integer> preMap = new HashMap<>();
        preMap.put(0,1);
        int pre = 0;
        for(int i = 0; i < nums.length ; i ++) {
            pre += nums[i];
            Integer preK = preMap.get(pre - k);
            if(preK != null) {
                count += preK;
            }
            preMap.put(pre, preMap.getOrDefault(pre,0)  + 1);

        }
        return count;
    }
    public int subarraySum3(int[] nums, int k) {
        int count = 0;
        for(int start = nums.length - 1; start >= 0; start --) {
            int sum  = 0;
            for(int end = start; end >= 0;  end -- ) {
                sum += nums[end];
                if(sum == k) {
                    count ++;
                }
            }
        }
        return count;
    }

    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        for(int start = 0; start < nums.length; start ++) {
            int sum  = 0;
            for(int end = start; end >= 0;  end -- ) {
                sum += nums[end];
                if(sum == k) {
                    count ++;
                }
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
