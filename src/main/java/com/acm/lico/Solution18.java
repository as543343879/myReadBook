package com.acm.lico; /**
 18 ,四数之和
 //给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
 //b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 //
 //
 // 0 <= a, b, c, d < n
 // a、b、c 和 d 互不相同
 // nums[a] + nums[b] + nums[c] + nums[d] == target
 //
 //
 // 你可以按 任意顺序 返回答案 。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：nums = [1,0,-1,0,-2,2], target = 0
 //输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 //
 //
 // 示例 2：
 //
 //
 //输入：nums = [2,2,2,2,2], target = 8
 //输出：[[2,2,2,2]]
 //
 //
 //
 //
 // 提示：
 //
 //
 // 1 <= nums.length <= 200
 // -10⁹ <= nums[i] <= 10⁹
 // -10⁹ <= target <= 10⁹
 //
 //
 // Related Topics 数组 双指针 排序 👍 1591 👎 0

 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
 自己思路：
    首先排序。 然后一个选值。 最后两个值 可以用 左右指针
        去重，在进入入口的时候去重

 去重处理问题；
 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 自己思路 ai优化：



 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution18 {
    /**
     *  自己思路：
     *  解答成功:
     *  执行耗时:13 ms,击败了69.75% 的Java用户
     *  内存消耗:42.9 MB,击败了6.42% 的Java用户
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        for(int i1 = 0; i1 < nums.length; i1 ++ ) {
            if(i1 > 0 && nums[i1] == nums[i1 - 1]) {
                continue;
            }
            int target1 = target - nums[i1] ;
            for(int i2 = i1 + 1; i2 < nums.length; i2 ++) {
                if(i2 > i1+1 && nums[i2] == nums[i2 - 1]) {
                    continue;
                }
                int target2 = target1 - nums[i2];
                int i4 = nums.length - 1;
                for(int i3 = i2 + 1; i3 < nums.length; i3 ++) {
                    if(i3 > i2+1 && nums[i3] == nums[i3 - 1]) {
                        continue;
                    }

                    while (i3 < i4 && (long)nums[i3] + nums[i4] > target2 ) {
                        i4--;
                    }
                    if( i3 >= i4){
                        break;
                    }
                    if((long) nums[i1] + nums[i2] + nums[i3] + nums[i4] == target) {
                        res.add(Arrays.asList(nums[i1], nums[i2], nums[i3], nums[i4]) );
//                        resMap.put(nums[i1] +"_"+ nums[i2]+"_"+ nums[i3]+"_"+ nums[i4],Arrays.asList(nums[i1], nums[i2], nums[i3], nums[i4]) );

                        while (i3 < i4 && nums[i4] == nums[i4-1]) {
                            i4--;
                        }

                    }

                }

            }

        }

        return res;
    }

    /**
     *  解答成功:
     *  执行耗时:30 ms,击败了10.58% 的Java用户
     *  内存消耗:42.7 MB,击败了10.06% 的Java用户
     *
     *  取消掉去重：
     *  解答成功:
     *  执行耗时:23 ms,击败了18.05% 的Java用户
     *  内存消耗:42.7 MB,击败了10.13% 的Java用户
     * ai 优化
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum3(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        int n = nums.length;
        for(int i1 = 0; i1 < n - 3; i1 ++ ) {
            int target1 = target - nums[i1] ;
            if(i1 > 0 && nums[i1] == nums[i1 - 1]) {
                continue;
            }
            for(int i2 = i1 + 1; i2 < n - 2; i2 ++) {
                int target2 = target1 - nums[i2];
                if(i2 > i1 + 1 && nums[i2] == nums[i2 - 1]) {
                    continue;
                }
                int i = i2 + 1, j = n - 1;
                while(i < j) {
                    if( (long) nums[i1] + nums[i2] + nums[i] + nums[j] == target) {
                        res.add(Arrays.asList(nums[i1], nums[i2], nums[i], nums[j]));
                        while(i < j && nums[i] == nums[i + 1]) {
                            i++;
                        }
                        while(i < j && nums[j] == nums[j - 1]) {
                            j--;
                        }
                        i++;
                        j--;
                    } else if ((long) nums[i] + nums[j] < target2) {
                        i++;
                    } else {
                        j--;
                    }
                }
            }
        }
//        Set<List<Integer>> set = new HashSet<>(res);
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
