package com.mg.redisSheJiYuShiXian.chaptor22;

/**
 * BitCount class
 *
 * @author 谢小平
 * @date 2020-09-30
 */
public class BitCount {
	private static byte[] wightInBit = {0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5, 4, 5, 5, 6, 3, 4, 4, 5, 4, 5, 5, 6, 4, 5, 5, 6, 5, 6, 6, 7};

	public static int swar(int i) {
		if(i <= Byte.MAX_VALUE) {
			return wightInBit[i];
		} else {
			i = (i & 0x55555555) + ((i >> 1) & 0x55555555);
			//第二步
			i = (i & 0x33333333) + ((i >> 2) & 0x33333333);
			//第三步
			i = (i & 0x0f0f0f0f) + ((i >> 4) & 0x0f0f0f0f);
			//第四步
			i = (i * (0x01010101) >> 24);
			return i;
		}

	}
}
