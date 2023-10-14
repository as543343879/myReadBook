package com.acm.lico;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Solution41 class
 *41. 缺失的第一个正数
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,0]
 * 输出：3
 * @author 谢小平
 * @date 2021/6/30
 */
public class Solution41 {
    /**
     * 内存超限
     * @param nums
     * @return
     */
    public int firstMissingPositiveError(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] > max)
                max = nums[i];
        }
        if(max != Integer.MAX_VALUE)
            max ++;
        int[] bitMap = new int[max];
        for(int i = 0; i < nums.length; i ++) {
            if(nums[i] < 0)
                continue;
            bitMap[nums[i]] = 1;
        }
        for(int i = 1; i < max; i ++) {
            if(bitMap[i]  == 0) {
                return i;
            }
        }
        return max;
    }

    public int firstMissingPositive(int[] nums) {
        Map<Integer,Boolean> map = new HashMap<>();
        for(int i : nums) {
            if(i <= 0)
                continue;
            map.put(i,true);
        }
        for(int i = 1; i <= Integer.MAX_VALUE; i ++) {
            if(!map.containsKey(i)) {
                return i;
            }
        }
        return 0;
    }

    public int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i ++) {
            if(nums[i] < 0) {
                nums[i] = n + 1;
            }
        }
        for(int i = 0; i < n; i ++) {
            int k = Math.abs(nums[i]);
            if(k <= n) {
                nums[k - 1] = - Math.abs(nums[k - 1]);
            }
        }
        for(int i = 0; i < n ; i ++) {
            if(nums[i] > 0)
                return i + 1;
        }
        return n + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution41().firstMissingPositiveNew20(new int[]{1,2,0}));
    }
    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度  O(NlogN)
     空间复杂度  O(logN)
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
     [-9,2] [1,2,3]
     思路：
     1. 先排序
     2. 从左到右边 是 正数 找出 num[i] + 1 != num[i + 1]
     3. 如果 num[0] >= 2 return 1;
     3. 如果 num[i] < 0 && num[i + 1] return 1


     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:11 ms,击败了13.96% 的Java用户
     内存消耗:57.3 MB,击败了80.23% 的Java用户
     */
    public int firstMissingPositiveNew20(int[] nums) {

        Arrays.sort(nums);
        int i = 0;
        if(nums[0] >= 2) {
            return 1;
        } else if(nums[0] < 0) {
            while ((i < nums.length) && (nums[i] < 0)) {
                i ++;
            }
            if((i >= nums.length) ||  (nums[i] > 1)) {
                return 1;
            }
        }
        int res = 0;
        for(; i < nums.length; i ++) {
            if((i + 1 < nums.length) &&  ( nums[i + 1] - nums[i] > 1 )) {
                res = nums[i] + 1;
                break;
            }
        }

        return  res != 0 ? res: nums[nums.length-1] + 1  ;
    }
}
