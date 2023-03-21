package com.acm.lico; /**
 46 ,全排列
 //给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：nums = [1,2,3]
 //输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 //
 //
 // 示例 2：
 //
 //
 //输入：nums = [0,1]
 //输出：[[0,1],[1,0]]
 //
 //
 // 示例 3：
 //
 //
 //输入：nums = [1]
 //输出：[[1]]
 //
 //
 //
 //
 // 提示：
 //
 //
 // 1 <= nums.length <= 6
 // -10 <= nums[i] <= 10
 // nums 中的所有整数 互不相同
 //
 //
 // Related Topics 数组 回溯 👍 2466 👎 0

 **/


import java.util.*;

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
 回溯，先选i，然后过程去取消选i。通过临时set 判断元素是否存在


 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 自己思路：
 解答成功:
 执行耗时:2 ms,击败了8.55% 的Java用户
 内存消耗:41.9 MB,击败了21.48% 的Java用户
 自己思路：通过临时list 来判断
 解答成功:
 执行耗时:1 ms,击败了83.87% 的Java用户
 内存消耗:41.7 MB,击败了46.13% 的Java用户


 更好的答案:
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution46 {
    List<List<Integer>> res = new ArrayList<>();

    /**
     * 自己思路
     * @param nums
     * @return
     */
    public List<List<Integer>> permute2(int[] nums) {
        backTrace2(nums, new LinkedHashSet<>(nums.length * 4 / 3  +1));
        return res;
    }

    public void backTrace2(int[] nums, Set<Integer> iTemp) {
        if(iTemp.size() == nums.length) {
            res.add(new ArrayList<>(iTemp));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            boolean addRes = iTemp.add(nums[i]);
            if(addRes) {
                backTrace2(nums, iTemp);
                iTemp.remove(nums[i]);
            }

        }
    }

    /**
     * 通过临时list 来判断
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        backTrace(nums, new ArrayList<>(nums.length ));
        return res;
    }

    public void backTrace(int[] nums, List<Integer> iTemp) {
        if(iTemp.size() == nums.length) {
            res.add(new ArrayList<>(iTemp));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!iTemp.contains(nums[i])) {
                iTemp.add(nums[i]);
                backTrace(nums, iTemp);
                iTemp.remove(iTemp.size() - 1);
            }

        }
    }


    /**
     * 更好的答案
     * @param nums
     * @return
     */
    public List<List<Integer>> permute3(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> outList = new ArrayList<>();
        for(int i = 0; i < nums.length; i ++) {
            outList.add(nums[i]);
        }
        tianchong(lists,outList,nums,0);
        return lists;
    }

    private void tianchong(List<List<Integer>> lists, List<Integer> outList, int[] nums, int left) {
        if(nums.length == left) {
            lists.add(new ArrayList<>(outList));
        }
        for(int i = left; i < nums.length; i ++) {
            Collections.swap(outList,i,left);
            tianchong(lists,outList,nums,left + 1);
            Collections.swap(outList,i,left);
        }

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(Arrays.toString(new Solution46().permute(nums).toArray()));
    }

}
//leetcode submit region end(Prohibit modification and deletion)
