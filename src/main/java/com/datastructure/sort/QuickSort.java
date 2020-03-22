package com.datastructure.sort;

import java.util.Arrays;

/**
 * QuickSort class
 */
public class QuickSort {

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
        long t;
        int m = low + (high - low) / 2 ;

        // 三个数 取中间值，把中间值放到sqList[low]
        if(sqList[low] > sqList[high])
            swap(sqList,low,high);
        if(sqList[m] > sqList[high])
            swap(sqList,m,high);
        if(sqList[m] > sqList[low] )
            swap(sqList,m,low);

        long middleValue = sqList[low];
        // 从数组两端交替向中间扫描
        while (low < high) {
            // 保证右边的大于等于中间值
            while (low < high && sqList[high] >= middleValue )
                high --;
            sqList[low] = sqList[high];
//            swap(sqList,low,high);

            // 保证左边的小于等于中间值
            while (low < high && sqList[low] <= middleValue)
                low ++;

            sqList[high] = sqList[low];
//            swap(sqList,low,high);

        }
        sqList[low] = middleValue;
        return low;
    }

    public void swap(long[] sqList, int low, int high) {
        long t = sqList[low];
        sqList[low] = sqList[high];
        sqList[high] = t;
    }

    public static void main(String[] args) {
        long[] sqList = {50,10,90,30,70,40,80,60,20};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(sqList,0,sqList.length-1);
        System.out.println(Arrays.toString(sqList));

         sqList = new long[]{50, 10, 90, 30, 70, 40, 80, 60};
        quickSort.sort(sqList,0,sqList.length-1);
        System.out.println(Arrays.toString(sqList));
    }
}
