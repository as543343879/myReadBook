package com.acm.lico.doNotKnow;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution315 class
 * https://leetcode.cn/problems/count-of-smaller-numbers-after-self/
 *315. 计算右侧小于当前元素的个数
 * 给你一个整数数组 nums ，按要求返回一个新数组 counts 。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [5,2,6,1]
 * 输出：[2,1,1,0]
 * 解释：
 * 5 的右侧有 2 个更小的元素 (2 和 1)
 * 2 的右侧仅有 1 个更小的元素 (1)
 * 6 的右侧有 1 个更小的元素 (1)
 * 1 的右侧有 0 个更小的元素
 * 示例 2：
 *
 * 输入：nums = [-1]
 * 输出：[0]
 * 示例 3：
 *
 * 输入：nums = [-1,-1]
 * 输出：[0,0]
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 通过次数66,421提交次数156,043
 *
 * @author 格林
 * @date 2022-07-18
 */
public class Solution315 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        for(int i = nums.length - 1; i >= 0; i --) {

        }
        return list;
    }
}
