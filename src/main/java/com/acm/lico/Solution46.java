package com.acm.lico;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Solution46 class
 *46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * @author 谢小平
 * @date 2021/6/30
 */
public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        dfs(nums,lists,new ArrayList<Integer>());
        return lists;
    }

    private void dfs(int[] nums, List<List<Integer>> lists,ArrayList<Integer> integers) {
        if(integers.size() == nums.length) {
            lists.add(new ArrayList<>(integers));
            return;
        }
        for(int i = 0; i < nums.length; i ++) {
            if(!integers.contains(nums[i])) {
                integers.add(nums[i]);
                dfs(nums,lists,integers);
                integers.remove(integers.size() - 1);
            }
        }
    }



    public static void main(String[] args) {
            int[] nums = {1,2,3};
            System.out.println(Arrays.toString(new Solution46().permute(nums).toArray()));
    }

    /**
     * 更好的答案
     * @param nums
     * @return
     */
    public List<List<Integer>> permute2(int[] nums) {
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


}
