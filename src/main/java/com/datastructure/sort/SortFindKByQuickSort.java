package com.datastructure.sort;

 
public class SortFindKByQuickSort {
 
	public static int getMiddle(int[] numbers, int low, int high) {
 
		int temp = numbers[low]; // 数组的第一个作为中轴
 
		while (low < high) {
 
			while (low < high && numbers[high] > temp) {
 
				high--;
			}
 
			numbers[low] = numbers[high];// 比中轴小的记录移到低端
 
			while (low < high && numbers[low] < temp) {
 
				low++;
			}
 
			numbers[high] = numbers[low]; // 比中轴大的记录移到高端
		}
 
		numbers[low] = temp; // 中轴记录到尾
 
		return low; // 返回中轴的位置
	}
 
	public static void quickSort(int[] numbers, int low, int high) {
 
		if (low < high) {
 
			int middle = getMiddle(numbers, low, high); // 将numbers数组进行一分为二
 
			quickSort(numbers, low, middle - 1); // 对低字段表进行递归排序
 
			quickSort(numbers, middle + 1, high); // 对高字段表进行递归排序
		}
	}
 
	public static int[] getMin(int[] numbers, int num) {
 
		int low = 0;
 
		int high = numbers.length - 1;
 
		int temp = numbers[low]; // 数组的第一个作为中轴
 
		int middle = getMiddle(numbers, low, high);
 
		if (middle > num) {
 
			int[] result = new int[middle];
 
			for (int i = 0; i < middle - 1; i++) {
 
				result[i] = numbers[i];
			}
 
			return getMin(numbers, num);
 
		} else {
 
			int[] result = new int[num];
 
			quickSort(numbers, 0, numbers.length - 1);
 
			for (int i = 0; i < num - 1; i++) {
 
				result[i] = numbers[i];
			}
			
			return result;
		}
	}
 
	public static void main(String[] args) {
 
		int[] numbers = { 10, 20, 15, 0, 6, 7, 2, 1, -5, 55 };
 
		int[] result = getMin(numbers, 2);
 
		for (int i : result) {
 
			System.out.println(i);
		}
	}
}