package com.acm.lico;

/**
 * Solution33 class
 *33. 搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 *
 * @author 格林
 * @date 2021-06-28
 */
public class Solution33 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right + 1) / 2;

            if(nums[mid] == target) {
                return mid;
            }
            // mid 在 左边线
            if(nums[0] < nums[mid]) {
                // [left,mid-1]
                if(nums[mid] > target && target >= nums[0]) {
                    right = mid - 1;
                // [mid + 1,right]
                } else {
                    left = mid + 1;
                }

             // mid 在 右边线
            } else {
                // [mid + 1,right]
                if(nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                // [left,mid - 1]
                } else {
                    right = mid - 1;

                }
            }
        }

        return -1;
    }

    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度 O(logN)
     空间复杂度 O(logN)
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
     思路： 二分查找 [4,5,6,7,0,1,2], target = 3
     1. 选取中间数 middle。 如果 target == middle 返回。
     2. 如果 left 和 middle 都大于 targe, 从 middle + 1 到 right找， 否则从 左边找。 思路错误。

     思路看了官方代码： 二分查找， 因为中位数左右两边 总有一边是有序的， 根据这个有序的，就能用排除法 缺点给边界
     1. 选取中位数，
     2. 如果 nums[left] < nums[middle] 左边有序， 根据左边排除
     - 如果 targe  小于 nums[left] 并且 小于  nums[middle] 。 从左边找
     - 否则 从右边
     3. 否则
     - 如果 tager 大于 nums[right] 并且小于 nums[middle], 从右边找
     - 否则从左边找

     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。

     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:0 ms,击败了100.00% 的Java用户
     内存消耗:39.7 MB,击败了71.20% 的Java用户
     */
    public int searchNew20(int[] nums, int target) {
        return findMiddle(nums, 0, nums.length - 1, target);
    }

    private int findMiddle(int[] nums, int left, int right,int target) {
        if(left > right) {
            return -1;
        }
        // 加一 防止出现 只有两个数的时候. middle = 1， 然后结果又在 0到1 一直循环
        int middle =  (right + left +1) / 2;
        if(nums[middle] == target) {
            return middle;
        }
//        2. 如果 nums[left] < nums[middle] 左边有序， 根据左边排除
//                - 如果 targe  小于 nums[left] 并且 小于  nums[middle] 。 从左边找
//                - 否则 从右边
//        3. 否则
//                - 如果 tager 大于 nums[right] 并且小于 nums[middle], 从右边找
//                - 否则从左边找
        if(nums[left] < nums[middle]) {
            if(target >= nums[left] && target < nums[middle] ) {
                return  findMiddle(nums, left, middle-1, target);
            } else {
                return findMiddle(nums, middle + 1, right, target);
            }
        } else {
            if(target > nums[middle] && target <= nums[right]) {
                return findMiddle(nums, middle + 1, right, target);
            } else {
                return  findMiddle(nums, left, middle-1, target);
            }
        }



    }
}
