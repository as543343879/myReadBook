package com.shejimoshi;

/**
 * Danli class
 * 单例模式
 * @author 谢小平
 * @date 2020-08-12
 */

public class Singleton {

	private Singleton() {
	}

	public static class ISingleton {
		private static final Singleton singleton = new Singleton();
	}
	public static Singleton  getSingleton() {
		return ISingleton.singleton;
	}

}
