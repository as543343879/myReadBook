/**
 78 ,子集
 //给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 //
 // 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 //
 //
 //
 // 示例 1：
 //
 //
 //输入：nums = [1,2,3]
 //输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 //
 //
 // 示例 2：
 //
 //
 //输入：nums = [0]
 //输出：[[],[0]]
 //
 //
 //
 //
 // 提示：
 //
 //
 // 1 <= nums.length <= 10
 // -10 <= nums[i] <= 10
 // nums 中的所有元素 互不相同
 //
 //
 // Related Topics 位运算 数组 回溯 👍 1977 👎 0

 **/

import java.util.ArrayList;
import java.util.LinkedList;
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

 自己思路：
 时间复杂度  nlogn
 空间复杂度  nlogn
 2 定位问题
 根据问题类型，确定采用何种算法思维。
 例如
 这个问题是什么类型（排序、查找、最优化）的问题；
 这个问题的复杂度下限是多少，即最低的时间复杂度可能是多少；
 采用哪些数据结构或算法思维，能把这个问题解决。
 自己思路：
 思路： 回溯， 细节 不能从后往前 遍历

 3 数据操作分析
 根据增、删、查和数据顺序关系去选择合适的数据结构，利用空间换取时间。
 4 编码实现
 5 执行结果
 自己思路：
 解答成功:
 执行耗时:1 ms,击败了26.40% 的Java用户
 内存消耗:41.5 MB,击败了67.71% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> tempOneRes = new ArrayList<>();
        backtracking(nums, 0, tempOneRes);
        return res;
    }

    public void backtracking(int[] nums, int index, List<Integer> tempOneRes ) {
        res.add(new ArrayList<>(tempOneRes));
        for(int i = index ; i < nums.length; i ++) {
            tempOneRes.add(nums[i]);
            backtracking(nums, i + 1, tempOneRes);
            tempOneRes.remove(tempOneRes.size() - 1);
        }
    }


    /**
     * 旧的提交。
     */
    List<List<Integer>> listList = new LinkedList<>();
    public List<List<Integer>> subsets2(int[] nums) {
        listList.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i ++) {
            dfs(listList,nums,i,new LinkedList<Integer>());
        }
        return listList;
    }

    private void dfs(List<List<Integer>> listList, int[] nums,int i,LinkedList<Integer> dataList) {
        int n = nums.length;
        dataList.add(nums[i]);
        listList.add(new ArrayList<>(dataList));
        // 推出的条件
        for(int k = i + 1; k < n; k ++) {
            dfs(listList,nums,k,dataList);
            dataList.remove(dataList.size() - 1);
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)
