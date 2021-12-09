package com.acm.lico.greedy;

/**
 * Solution452 class
 *
 * @author 谢小平
 * @date 2021/12/8
 */

import java.util.Arrays;
import java.util.Comparator;

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
public class Solution452 {

    public int findMinArrowShots(int[][] points){
        Arrays.sort(points, Comparator.comparingInt(e->e[1]));
        Arrays.stream(points).forEach(e->System.out.println(Arrays.toString(e)));
        int count = 1;
        int right = points[0][1];
        for(int i = 1; i < points.length; i ++) {
            while (i < points.length && points[i][1] < right) {
                i++;
            }
            count++;
            if(i < points.length) {
                right = points[i][1] + 1;

            }

        }
        return count;
    }

    public int findMinArrowShots_RROE(int[][] points) {
//        Arrays.sort(points, Comparator.comparingInt(e->e[1]));
        Arrays.sort(points, (o1,o2)->{

             long res =( (long) o1[1] - (long)o2[1]) ;
             int resInt = res > 0 ? 1 : res==0 ? 0 : -1 ;

            if(res == 0) {
                return o1[0] - o2[0];
            }
            return resInt;
        });
//        Arrays.sort(points,new Comparator<int[]>(){
//
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                int res = o1[0] - o2[0];
//                if(res == 0) {
//                    return o1[1] - o2[1];
//                }
//                return res;
//            }
//        });
        Arrays.stream(points).forEach(e->System.out.println(Arrays.toString(e)));
        int count = 1;
        int right = points[0][1];
        for(int i = 1; i < points.length; i ++) {
            if(right <= points[i][0]) {
                System.out.println("right:" + right + " points["+i+"][0]： " +  points[i][0]);
                if(right == points[i][0]) {
                    if((i + 1) < points.length) {
                        i++;
                        count ++;
                        right = points[i ][1];
                    } else {
                        return count;
                    }
//                    System.out.println("right:" + right + " points["+i+"][0]： " +  points[i][0]);


                } else {
                    count ++;
                    right = points[i][1];
                }


            }

        }
        return count;
    }

    public static void main(String[] args) {
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
//        int[][] points = {{1,2},{3,4},{5,6},{7,8}};
//        int[][] points = {{1,2},{2,3},{3,4},{4,5}};
//        int[][] points = {{-2147483646,-2147483645},{2147483646,2147483647}};
//        int[][] points = {{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};
//        int[][] points = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        System.out.println(new Solution452().findMinArrowShots(points));
    }
}
