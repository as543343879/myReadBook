package com.acm.lico.doNotKnow;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution169 class
 *https://leetcode.cn/problems/majority-element/
 * 169. 多数元素
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 *
 * 提示：
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 *  
 *
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 谢小平
 * @date 2022/6/21
 */
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
 3 数据操作分析
    根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 */
public class Solution169 {
    /**
     * 执行用时： 11 ms , 在所有 Java 提交中击败了 27.65% 的用户
     * 内存消耗： 46.6 MB , 在所有 Java 提交中击败了 10.94% 的用户
     * 通过测试用例： 43 / 43
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int isMajority = nums.length / 2 + 1;
        for(int i = 0; i < nums.length; i ++) {
            Integer tempRes = map.get(nums[i]) ;
            if (tempRes == null) {
                tempRes = 0;
            }
            ++tempRes;
            if (tempRes >= isMajority) {
                return nums[i];
            }
            map.put(nums[i], tempRes);
        }
        return 0;
    }

    /**
     * 执行结果： 通过 显示详情 添加备注 执行用时： 1373 ms ,
     * 在所有 Java 提交中击败了 5.14% 的用户 内存消耗： 44.5 MB ,
     * 在所有 Java 提交中击败了 91.40% 的用户 通过测试用例： 43 / 43
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if(nums.length <= 2) {
            return nums[0];
        }
        int isMajority = nums.length / 2 ;
        for(int i = 0; i <= isMajority; i ++) {
            int tempRes = nums[i];
            int count = isInRight(nums,isMajority,tempRes);
            if( count > 0 || i >= isMajority ) {
                for(int k = 0; k <= isMajority; k ++) {
                    if(nums[k] == tempRes) {
                        count++;
                        if (count > isMajority) {
                            return tempRes;
                        }
                    }

                }
            }

        }
        return 0;
    }

    public int isInRight(int[] nums, int isMajority, int targe) {
        int count = 0;

        for(int i = isMajority + 1; i < nums.length; i ++) {
            if(targe == nums[i]) {
                count++;
            }
        }
        return count;

    }
    public static void main(String[] args) {
        int[] test = {3,3,4};
        test = new int[]{6, 5, 5};
        System.out.println(new Solution169().majorityElement(test));
    }
}
