package com.mg.daXingFenBuShiWangZhanJiaGou;

import org.junit.Test;

import java.security.MessageDigest;

/**
 * Main class
 *
 * @author 谢小平
 * @date 2020-05-27
 */
public class Main {
	private static final char[] HEX_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

	@Test
	public void test1() {
		try {
			byte[] value = testSHA1("xx");
			System.out.println(value.length);
			System.out.println(encodeHex(value));
			System.out.println(encodeHex(value).length);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test2() {
		try {
			byte[] value = testMD5("xx");
			System.out.println(value.length);
			System.out.println(encodeHex(value));
			System.out.println(encodeHex(value).length);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static char[] encodeHex(byte[] bytes) {
		char[] chars = new char[32];

		for (int i = 0; i < chars.length; i += 2) {
			byte b = bytes[i / 2];
			chars[i] = HEX_CHARS[b >>> 4 & 15];
			chars[i + 1] = HEX_CHARS[b & 15];
		}

		return chars;
	}

	public static byte[] testMD5(String content) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] bytes = md.digest(content.getBytes("utf8"));
		return bytes;
	}

	public static byte[] testSHA1(String content) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		byte[] bytes = md.digest(content.getBytes("utf8"));
		return bytes;
	}
}
