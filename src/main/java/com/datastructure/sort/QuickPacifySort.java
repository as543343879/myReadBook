package com.datastructure.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * QuickSort class
 * 快速排序
 */
public class QuickPacifySort {

    public void sort(long[] sqList, int low, int high){
        //中间数下标
        int middle;
        if(low < high) {
            //算出中间值下标
            middle = partition(sqList,low,high);
            sort(sqList,low,middle-1);
            sort(sqList,middle+1,high);
        }
    }

    public int partition(long[] sqList, int low, int high) {
        if( low >= high) {
            return low;
        }
        int offset = low;
        long middleValue = sqList[low];

        List<Long> leftList = new ArrayList<>();
        List<Long> rightList = new ArrayList<>();

        for(int i = low; i <= high; i ++) {
            if(sqList[i] < middleValue) {
                leftList.add(sqList[i]);
            } else {
                rightList.add(sqList[i]);
            }
        }
        int start = 0;
        for(; start < leftList.size(); start ++) {
            sqList[low + start] = leftList.get(start);
        }
        start = low + start;
        for(int i = 0; i < rightList.size(); i ++) {
            sqList[start ++] = rightList.get(i);
        }
        return low;
    }

    public void swap(long[] sqList, int low, int high) {
        long t = sqList[low];
        sqList[low] = sqList[high];
        sqList[high] = t;
    }

    public static void main(String[] args) {
        long[] sqList = {50,10,90,30,70,40,80,60,20};
        QuickPacifySort quickSort = new QuickPacifySort();
        quickSort.sort(sqList,0,sqList.length-1);
        System.out.println(Arrays.toString(sqList));

         sqList = new long[]{50, 10, 90, 30, 70, 40, 80, 60};
        quickSort.sort(sqList,0,sqList.length-1);
        System.out.println(Arrays.toString(sqList));
    }
}
