package com.jdk8;

import java.util.Arrays;

/**
 * ByteTest class
 *
 * @author 谢小平
 * @date 2020-09-30
 */
public class ByteTest {
	public static void main(String[] args) {
	    System.out.println(Byte.MAX_VALUE);
		System.out.println(Integer.bitCount(Byte.MAX_VALUE));
		byte[] weightInByte = new byte[256];
	    for(int i = -128; i <= Byte.MAX_VALUE; i ++) {
		    weightInByte[i + 128] = (byte) Integer.bitCount(i);
	    }
	    System.out.println(Arrays.toString(weightInByte));
	}
}
