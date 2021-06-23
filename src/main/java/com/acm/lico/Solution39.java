package com.acm.lico;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution39 class
 * 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 * @author 格林
 * @date 2021-06-21
 */
public class Solution39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> listList = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        dfs(listList,list,candidates,target,0);
        return listList;
    }

    private void dfs(List<List<Integer>> listList, List<Integer> list, int[] candidates, int target, int i) {
        if(i == candidates.length) {
            return ;
        }

        if(target == 0) {
            listList.add(new ArrayList<>(list));
            return ;
        }
        dfs(listList,list,candidates,target,i + 1);
        if(target - candidates[i] >= 0) {
            list.add(candidates[i]);
            dfs(listList,list,candidates,target - candidates[i],i );
            list.remove(list.size() - 1);
        }
    }
}
