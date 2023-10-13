package com.acm.lico;

/**
 * Solution34 class
 *34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *
 * @author 格林
 * @date 2021-06-29
 */
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (right + left) / 2;
            if(nums[mid] == target) {
                int begin = mid,end = mid;
                while (begin - 1 >= 0 && nums[begin - 1] == target) {
                    begin--;
                }
                while (end + 1 < nums.length && nums[end + 1] == target) {
                    end++;
                }
                return new int[]{begin,end};
            } else if(nums[mid] <  target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return new int[]{-1,-1};
    }


    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度  O(logN)
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
     思路：
     1. 先根据二分查找，找到目标值的位置
     2. 如果找到就向两边扩散。找到左右边界
     3. 如果没找到，直接返回[-1, -1]
     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:0 ms,击败了100.00% 的Java用户
     内存消耗:43.1 MB,击败了93.63% 的Java用户
     */
    public int[] searchRangeNew20(int[] nums, int target) {
        int bySearch = findBySearch(nums, 0, nums.length-1, target);
        if(bySearch == -1) {
            return new int[] {-1, -1};
        }
        int left = bySearch;
        if(nums[0] == target) {
            left = 0;
        } else {
            while (left >= 0 && nums[left] == target) {
                left --;
            }
            left ++;
        }

        int right = bySearch;
        if(nums[nums.length - 1] == target) {
            right = nums.length -1;
        } else {
            while (right < nums.length && nums[right] == target) {
                right ++;
            }
            right --;
        }

        return new int[] {left, right};
    }

    private int findBySearch(int[] nums, int left, int right, int target) {
        if( left > right) {
            return -1;
        }
        int middle = (right + left + 1) / 2;
        if(nums[middle] == target) {
            return middle;
        } else if(nums[middle] < target) {
            return findBySearch(nums, middle + 1, right, target);
        } else {
            return findBySearch(nums, left, middle - 1, target);
        }

    }
}
