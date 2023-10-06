package com.acm.lico; /**
 15 ,三数之和
 //给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j !=
 //k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 //
 // 你返回所有和为 0 且不重复的三元组。
 //
 // 注意：答案中不可以包含重复的三元组。
 //
 //
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：nums = [-1,0,1,2,-1,-4]
 //输出：[[-1,-1,2],[-1,0,1]]
 //解释：
 //nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 //nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 //nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 //不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 //注意，输出的顺序和三元组的顺序并不重要。
 //
 //
 // 示例 2：
 //
 //
 //输入：nums = [0,1,1]
 //输出：[]
 //解释：唯一可能的三元组和不为 0 。
 //
 //
 // 示例 3：
 //
 //
 //输入：nums = [0,0,0]
 //输出：[[0,0,0]]
 //解释：唯一可能的三元组和为 0 。
 //
 //
 //
 //
 // 提示：
 //
 //
 // 3 <= nums.length <= 3000
 // -10⁵ <= nums[i] <= 10⁵
 //
 //
 // Related Topics 数组 双指针 排序 👍 5740 👎 0

 **/

import com.acm.lico.Solution15;

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
 参考后的思路： 错误
 时间复杂度O(N^3)
 空间复杂度O(1)

 参考后的思路： 正确
 时间复杂度O(N^2)
 空间复杂度O(logN) 排序的空间复杂度


 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 自己思路：
 暴力， 三从循环模拟

 参考后的思路：
 先排序， 排序碰到相等的可以跳过。第三重循环 可以根据 有序性， 从后往前推。 第二层循环是变大的， 第三层循环一定要变小。

 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 参考后的思路：
 执行耗时:28 ms,击败了70.76% 的Java用户
 内存消耗:48.6 MB,击败了38.76% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution15 {


    /**
     1 复杂度分析
     估算问题中复杂度的上限和下限
     时间复杂度  O(N^2)
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
     思路：
     1. 先排序， 这样能避免 重复
     2. 循环获取 选择 ti。
     3. 然后 双指针 tj,tk。 把 -ti = tj + tk 结果等于0 放入结果集

     3 数据操作分析
     根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
     解答成功:
     执行耗时:43 ms,击败了20.45% 的Java用户
     内存消耗:49 MB,击败了85.31% 的Java用户
     */
    public List<List<Integer>> threeSumNew20(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i ++ ) {
            if((i != 0) &&( nums[i] == nums[i-1]) ) {
                continue;
            }
            int valuei = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if( (left > i + 1) &&  (nums[left] == nums[left - 1])) {
                    left ++ ;
                    continue;
                }
                if( (right != nums.length - 1) && (nums[right] == nums[right + 1])  ) {
                    right --;
                    continue;
                }
                if(nums[left] + nums[right] == valuei) {
                    List<Integer> tempList = new ArrayList(3);
                    tempList.add(nums[i]);
                    tempList.add(nums[left]);
                    tempList.add(nums[right]);
                    res.add(tempList);
                    left ++;
                    right -- ;
                } else if(nums[left] + nums[right] > valuei) {
                    right -- ;
                } else {
                    left ++;
                }

            }
        }
        return res;
    }
    /**
     1 复杂度分析
    估算问题中复杂度的上限和下限
     时间复杂度  O(N^2
     空间复杂度 O(1)错误 应该是 O(LgN) 排序的空间复杂度
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
            1. 先排序，然后二重循环模拟。
            2. 第二重循环里面，第二个数字，从左往右， 第三个数 从右往左。 特点是，第二个数是变大的，第三个数是变小的。
            3. 去重 1. 第二个数相等，跳过。 2. 第三个数相等，跳过。
     3 数据操作分析
        根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
     4 编码实现
     5 执行结果
         解答成功:
         执行耗时:43 ms,击败了20.92% 的Java用户
         内存消耗:50.2 MB,击败了24.74% 的Java用户
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resList = new ArrayList<>();
        for(int i = 0; i < nums.length; i ++) {
            int sum = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while(left < right) {
                if(nums[left] + nums[right] == sum) {
                    if(left > i + 1 && nums[left] == nums[left - 1]) {
                        left ++;
                        continue;
                    }
                    List<Integer> tempOne = new ArrayList<>();
                    tempOne.add(nums[i]);
                    tempOne.add(nums[left]);
                    tempOne.add(nums[right]);
                    resList.add(tempOne);
                    left ++;
                    right --;
                } else if(nums[left] + nums[right] < sum) {
                    left ++;
                } else {
                    right --;
                }
            }

        }
        return resList;
    }
    /**
     * 刷第一遍的正确答案
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSumOld(int[] nums) {
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
//        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        new Solution15().threeSumNew20(arr);
    }

    public List<List<Integer>> threeSumOld2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0 ; i < nums.length; i ++ ) {
            int sum = -nums[i];
            if((i > 0 && nums[i] == nums[i-1]) || sum < 0) {
                continue;
            }

            int k = nums.length - 1;
            for(int j = i + 1; j < nums.length; j ++) {
                if(j > i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }
                while (k > j && nums[j] + nums[k] > sum) {
                    k --;
                }
                if(k == j) {
                    break;
                }
                if( nums[j] + nums[k] == sum) {
                    List<Integer> tempList = new ArrayList<>(3);
                    tempList.add(nums[i]);
                    tempList.add(nums[j]);
                    tempList.add(nums[k]);
                    res.add(tempList);
                }

            }

        }

        return res;

    }
    /**
     * 暴力 时间超限
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum3(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0 ; i < nums.length; i ++ ) {
            int sum = nums[i];
            if((i > 0 && nums[i] == nums[i-1]) || sum > 0) {
                continue;
            }
            for(int j = i + 1; j < nums.length; j ++) {
                if(j > i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int sumj= nums[j] + sum;
                for(int k = j + 1; k < nums.length;  k++) {
                    if(k > j + 1 && nums[k] == nums[k-1]) {
                        continue;
                    }
                    int sumK = sumj + nums[k];
                    if(sumK == 0) {
                        List<Integer> tempList = new ArrayList<>(3);
                        tempList.add(nums[i]);
                        tempList.add(nums[j]);
                        tempList.add(nums[k]);
                        res.add(tempList);
                    }
                }
            }

        }

        return res;

    }
    /**
     *  暴力不行， 因为还要单独去除， 代价太大了。
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0 ; i < nums.length; i ++ ) {
            int sum = nums[i];
            for(int j = i + 1; j < nums.length; j ++) {
                int sumj= nums[j] + sum;
                for(int k = j + 1; k < nums.length;  k++) {
                    int sumK = sumj + nums[k];
                    if(sumK == 0) {
                        List<Integer> tempList = new ArrayList<>(3);
                        tempList.add(nums[i]);
                        tempList.add(nums[j]);
                        tempList.add(nums[k]);
                        res.add(tempList);
                    }
                }
            }

        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
