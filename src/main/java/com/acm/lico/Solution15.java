package com.acm.lico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution15 class
 * 15. 三数之和
 *  给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。0
 * @author 格林
 * @date 2021-06-21
 */
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        Arrays.sort(nums);
        int sum = 0;
        for(int one = 0; one < nums.length; one ++) {
            if(one > 0 && nums[one] == nums[one - 1]) {
                continue;

            }
            sum = -nums[one];
            int three = nums.length - 1;
            for(int two = one + 1; two < nums.length ; two ++ ) {
                if(two > one + 1 && nums[two] == nums[two - 1]) {
                    continue;
                }
                while (two < three && nums[two] + nums[three] > sum){
                    three -- ;
                }
                if(two == three) {
                    break;
                }
                if(nums[two] + nums[three] == sum) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[one]);
                    list.add(nums[two]);
                    list.add(nums[three]);
                    listList.add(list);
                }

            }
        }
        return listList;
    }
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        new Solution15().threeSum(arr);
    }
}
