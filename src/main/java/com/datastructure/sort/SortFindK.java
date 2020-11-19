package com.datastructure.sort;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.BitSet;
import java.util.PriorityQueue;

/**
 * SortTest class
 *
 * @author 谢小平
 * @date 2020-09-11
 */
public class SortFindK {
	public static void main(String[] args) {
		try {
//			System.out.println(Arrays.toString(findMaxs("F:\\test.txt")));
			Arrays.toString(findMaxs("F:\\test.txt"));
			Arrays.toString(findMaxs2("F:\\test.txt"));

//			System.out.println(Arrays.toString(findMaxTong("F:\\test.txt")));
//			System.out.println(Arrays.toString(findMaxSet("F:\\test.txt")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static int[] findMaxSet(String fileUrl) throws IOException {
		BitSet bitSet = new BitSet(1000_000_01); // 100亿以内
		int len = 1024 * 1024;
		FileReader fr = new FileReader(fileUrl);
		BufferedReader bf = new BufferedReader(fr, len);
		String str;
		Integer value;
		while ((str = bf.readLine()) != null) {
			value = Integer.valueOf(str);
			bitSet.set(value);
		}
		int size = 100;
		int count = 0;
		int[] maxArr  = new int[size];
		for(int i = bitSet.size() - 1; i > -1 && count< size; i --) {
			if(bitSet.get(i) ) {
				maxArr[count++] = i;
			}
		}
		return maxArr;
	}

	public static int[] findMaxTong(String fileUrl) throws IOException {
		short[] buLong = new short[1000_000_01];
		int len = 1024 * 1024;
		FileReader fr = new FileReader(fileUrl);
		BufferedReader bf = new BufferedReader(fr, len);
		String str;
		Integer value;
		while ((str = bf.readLine()) != null) {
			value = Integer.valueOf(str);
			buLong[value] ++;
		}
		int size = 100;
		int count = 0;
		short t;
		int[] maxArr  = new int[100];
		for(int i = buLong.length - 1; i > -1 && count< 100; i --) {
			if((t = buLong[i]) != 0) {
				for(int k  = 0; k < t&& count< 100; k++ ) {
					maxArr[count++] = i;
				}
			}
		}
		return maxArr;
	}

	/**
	 * 获取到这个文件里面数字的最大前100个数
	 * @param fileUrl 文件的地址路径
	 * @return
	 * @throws Exception
	 */
	public static int[] findMaxs(String fileUrl) throws IOException {
		//100个数
		int size = 100;

		//为bufferedReader 创建默认缓冲区大小 单位字符
		int len = 1024 * 1024;

		//使用大小堆 进行数据的前100个筛选
		//大顶堆
		PriorityQueue<Integer> maxQueue = new PriorityQueue<>(size, (o1, o2) -> o2 - o1);
		//小顶堆
		PriorityQueue<Integer> minQueue = new PriorityQueue<>(size);

		FileReader fr = new FileReader(fileUrl);
		BufferedReader bf = new BufferedReader(fr, len);
		String str;
		int i = 0;
		int value;

		// 按行读取字符串
		//获取前size个数据，不需要进行比较
		while (i ++ < size && (str = bf.readLine()) != null) {
			value = Integer.valueOf(str);
			maxQueue.offer(value);
			minQueue.offer(value);
		}

		while ((str = bf.readLine()) != null) {
			value = Integer.valueOf(str);
			//将读取到得值跟最大size个数中最小的数进行比较，大于的话需要替换它
			if (value > minQueue.peek()) {
				maxQueue.remove(minQueue.peek());
				minQueue.poll();

				maxQueue.offer(value);
				minQueue.offer(value);
			}
		}

		//进行数据读取到数组中
		int[] maxArr = new int[size];
		for (i = 0; i < size; i ++) {
			maxArr[i] = maxQueue.poll();
		}

		int[] minArr = new int[size];
		for (i = 0; i < size; i ++) {
			minArr[i] = minQueue.poll();
		}

		System.out.println(Arrays.toString(minArr));
		return maxArr;
	}

	public static int[] findMaxs2(String fileUrl) throws IOException {
		//100个数
		int size = 100;

		//为bufferedReader 创建默认缓冲区大小 单位字符
		int len = 1024 * 1024;

		//使用大小堆 进行数据的前100个筛选
		//小顶堆
		PriorityQueue<Integer> minQueue = new PriorityQueue<>(size);

		FileReader fr = new FileReader(fileUrl);
		BufferedReader bf = new BufferedReader(fr, len);
		String str;
		int i = 0;
		int value;

		//获取前size个数据，不需要进行比较
		while (i ++ < size && (str = bf.readLine()) != null) {
			value = Integer.valueOf(str);
			minQueue.offer(value);
		}

		while ((str = bf.readLine()) != null) {
			value = Integer.valueOf(str);
			if (value > minQueue.peek()) {
				minQueue.poll();
				minQueue.offer(value);
			}
		}

		int[] minArr = new int[size];
		for (i = 0; i < size; i ++) {
			minArr[i] = minQueue.poll();
		}
		System.out.println(Arrays.toString(minArr));
		return minArr;
	}


}
