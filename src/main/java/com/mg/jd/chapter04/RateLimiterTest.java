package com.mg.jd.chapter04;

import com.google.common.util.concurrent.RateLimiter;

/**
 * RateLimiterTest class
 *
 * @author 谢小平
 * @date 2020-10-12
 */
public class RateLimiterTest {
	public static void main(String[] args) {
		RateLimiter limiter = RateLimiter.create (5);
		System.out.println(limiter.acquire());
		System.out.println(limiter.acquire());
		System.out.println(limiter.acquire());
		System.out.println(limiter.acquire());
		System.out.println(limiter.acquire());
		System.out.println(limiter.acquire());

	}
}
