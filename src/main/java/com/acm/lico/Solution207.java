package com.acm.lico;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution207 class
 * 207. 课程表 判读图是否有环
 * @author 格林
 * @date 2021-06-19
 */
public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> mapList = new ArrayList<>();
        for(int i = 0; i < numCourses; i  ++) {
            mapList.add(new ArrayList<>());
        }
        int[] flags = new int[numCourses];
        for(int[] t : prerequisites) {
            mapList.get(t[0]).add(t[1]);
        }
        for(int i = 0; i < numCourses; i ++) {
            if(!dfs(mapList,flags,i)) return false;
        }
        return true;
    }

    /**
     *
     * @param mapList
     * @param flags -1 以前走过， 1 本轮走过
     * @param i
     * @return
     */
    private boolean dfs(List<List<Integer>> mapList, int[] flags, int i) {
        if(flags[i] == 1)
            return false;
        if(flags[i] == -1)
            return true;
        flags[i] = 1;
        for(int j : mapList.get(i)) {
            if(!dfs(mapList,flags,j))
                return false;
        }
        flags[i] = -1;
        return true;
    }
}
