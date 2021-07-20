package com.acm.lico;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Solution78 class
 * 1 复杂度分析
 *   O(nlogn)
 * 2 定位问题
 *   深度遍历 加 回溯
 * 3 数据操作分析
 *   无特殊数据操作
 * 4 实现分析
 *     - 递归回溯用的不是很熟
 *
 * @author 谢小平
 * @date 2021/7/20
 */
public class Solution78 {
    List<List<Integer>> listList = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
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
