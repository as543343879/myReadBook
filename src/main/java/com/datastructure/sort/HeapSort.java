package com.datastructure.sort;

import java.util.Arrays;

/**
 * HeapSort class
 *
 * @author 格林
 * @date 2021-05-27
 */
public class HeapSort {

    // 局部修正
    public static void  correction(long arr[],int n, int i) {
        if(i >= n) {
            return ;
        }
        int leftChild = i * 2 + 1;
        int rightChild = i * 2 + 2;
        int max = i;
        if(leftChild < n && arr[leftChild] > arr[max]) {
            max = leftChild;
        }
        if(rightChild < n && arr[rightChild] > arr[max]) {
            max = rightChild;
        }
        if(i != max) {
            swap(arr,i,max);
            // 修正交换了的子树，保证是大顶堆。
            correction(arr,n,max);
        }

    }

    /**
     * 从倒数第二层开始构建，构建大顶堆
     * @param arr
     */
    public static void buildHeap(long[] arr) {
        int startIndex =  (arr.length - 2 ) / 2;
        for(int i = startIndex; i >= 0; i --) {
            correction(arr,arr.length, i);
        }

    }

    /**
     * 堆排序
     * @param arr
     */
    public static  void sortHeap(long[] arr) {
        // 构建大顶堆
        buildHeap(arr);
        for(int i = arr.length - 1; i >= 0; i -- ) {
            swap(arr,0,i);
            correction(arr,i ,0);

        }
    }
    public static void main(String[] args) {
        //long[] arr = {1,5,2,3,11,7,2222,333,11,2,3,4};
        long[] arr = {10,2,1,3,4,5,11,2312,321321};
        System.out.println("原始前" + Arrays.toString(arr));
        sortHeap(arr);
       System.out.println("排序后" +  Arrays.toString(arr));
    }

    public static  void swap(long[] arr, int start, int end) {
        long t = arr[start];
        arr[start] = arr[end];
        arr[end] = t;
    }
}
