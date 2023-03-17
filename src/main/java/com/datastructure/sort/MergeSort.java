package com.datastructure.sort;

import java.util.Arrays;

/**
 * MergeSort class
 *
 * @author 谢小平
 * @date 2023/3/17
 */
public class MergeSort {
    /**
     * 从小到大
     * @param a
     * @param left
     * @param right
     */
    public void sort(int[] a, int left, int right) {
        if(left >= right) {
            return ;
        }
        int mid = (left + right) / 2;
        sort(a,left,mid);
        sort(a,mid + 1, right);
        merge(a,left,mid,right);
    }
    public void merge(int[] a, int left, int mid, int right) {
        int[] copyArray = new int[right - left + 1];
        System.arraycopy(a,left, copyArray, 0, copyArray.length);
        int leftI = left;
        int midI = mid + 1;
        for(int i = leftI; i <= right; i ++) {
            if(leftI > mid) {
                a[i] = copyArray[midI++ - left];
            } else if(midI > right) {
                a[i] = copyArray[leftI++ - left];
            } else if(copyArray[midI- left] > copyArray[leftI-left]) {
                a[i] = copyArray[leftI++ - left];
            } else {
                a[i] = copyArray[midI ++ - left];
            }

        }

    }

    public static void main(String[] args) {
        int[] sqList = {50,10,90,30,70,40,80,60,20};
        MergeSort quickSort = new MergeSort();
        quickSort.sort(sqList,0,sqList.length-1);
        System.out.println(Arrays.toString(sqList));

        sqList = new int[]{50, 10, 90, 30, 70, 40, 80, 60};
        quickSort.sort(sqList,0,sqList.length-1);
        System.out.println(Arrays.toString(sqList));
    }


}
